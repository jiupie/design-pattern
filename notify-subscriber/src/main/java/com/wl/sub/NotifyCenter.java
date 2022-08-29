package com.wl.sub;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 南顾北衫
 */
public class NotifyCenter {

    /**
     * 默认事件发布者工厂
     */
    private static final EventPublisherFactory DEFAULT_PUBLISH_FACTORY;


    /**
     * 默认事件发布者
     */
    private static final EventPublisher DEFAULT_PUBLISH;

    public static int ringBufferSize = 16384;


    /**
     * 默认的事件推送者
     */
    private static Class<? extends EventPublisher> DEFAULT_EVENT_PUBLISHER_CLAZZ;


    /**
     * 所有的发布者管理
     */
    private final ConcurrentHashMap<String, EventPublisher> publisherMap = new ConcurrentHashMap<>(16);

    private static final NotifyCenter INSTANCE = new NotifyCenter();


    static {
        DEFAULT_EVENT_PUBLISHER_CLAZZ = DefaultPublisher.class;

        DEFAULT_PUBLISH_FACTORY = (cls, buffer) -> {
            try {
                //实例化事件发布者
                EventPublisher eventPublisher = DEFAULT_EVENT_PUBLISHER_CLAZZ.newInstance();
                //初始化工作
                eventPublisher.init(cls, buffer);

                return eventPublisher;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("");
            }
        };

        DEFAULT_PUBLISH = new DefaultPublisher();
    }

    /**
     * 发布事件
     *
     * @param event 事件
     * @return /
     */
    public static boolean publishEvent(final Event event) {
        Objects.requireNonNull(event);
        String topic = event.getClass().getCanonicalName();
        EventPublisher eventPublisher = INSTANCE.publisherMap.get(topic);
        if (Objects.nonNull(eventPublisher)) {
            return eventPublisher.publish(event);
        }
        return false;
    }


    /**
     * 添加事件发布者和事件的绑定关系
     *
     * @param eventType      事件类型
     * @param eventPublisher 事件发布者
     */
    public static void registerToPublisher(final Class<? extends Event> eventType, final EventPublisher eventPublisher) {
        //参数校验
        Objects.requireNonNull(eventType);
        Objects.requireNonNull(eventPublisher);

        String topic = eventType.getCanonicalName();
        synchronized (NotifyCenter.class) {
            INSTANCE.publisherMap.put(topic, eventPublisher);
        }
    }

    //==================================事件订阅者

    /**
     * 添加订阅者到默认的发布者中{@link DefaultPublisher}
     */
    public static void registerSubscriber(final Subscriber consumer) {
        registerSubscriber(consumer, DEFAULT_PUBLISH_FACTORY);
    }

    public static void registerSubscriber(Subscriber consumer, EventPublisherFactory defaultPublishFactory) {
        final List<Class<? extends Event>> subscribeType = consumer.subscribeTypes();
        for (Class<? extends Event> eventType : subscribeType) {
            addSubscriber(consumer, eventType, defaultPublishFactory);
        }
    }

    private static void addSubscriber(Subscriber consumer, Class<? extends Event> subscribeType, EventPublisherFactory defaultPublishFactory) {
        EventPublisher eventPublisher = defaultPublishFactory.apply(subscribeType, ringBufferSize);
        INSTANCE.publisherMap.put(subscribeType.getCanonicalName(), eventPublisher);

        eventPublisher.addSubscriber(consumer);
    }

}
