package com.wl.sub;

/**
 * @author 南顾北衫
 */
public interface EventPublisher {

    /**
     * 发布事件
     *
     * @param event 事件
     * @return /
     */
    boolean publish(Event event);


    /**
     * 通知订阅者
     *
     * @param subscriber 订阅者
     * @param event      事件
     */
    void notifySubscriber(Subscriber subscriber, Event event);

    /**
     * 添加订阅者
     *
     * @param subscriber {@link com.wl.sub.Subscriber}
     */
    void addSubscriber(Subscriber subscriber);


    /**
     * 移除订阅者
     *
     * @param subscriber {@link com.wl.sub.Subscriber}
     */
    void removeSubscriber(Subscriber subscriber);

    /**
     * 初始化事件发布者
     *
     * @param eventType  事件发布者
     * @param bufferSize 队列大小
     */
    void init(Class<? extends Event> eventType, int bufferSize);


}
