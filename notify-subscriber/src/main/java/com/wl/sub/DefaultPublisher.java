package com.wl.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 事件发布者  线程
 *
 * @author 南顾北衫
 */
public class DefaultPublisher extends Thread implements EventPublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPublisher.class);

    /**
     * 队列的最大长度
     */
    private int queueMaxSize = -1;

    /**
     * 阻塞的事件队列
     */
    private BlockingQueue<Event> queue;

    private volatile boolean initialized = false;

    private volatile boolean shutdown = false;

    private volatile Long lastEventSequence = -1L;

    private static final AtomicReferenceFieldUpdater<DefaultPublisher, Long> UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPublisher.class, Long.class, "lastEventSequence");

    private final ConcurrentHashSet<Subscriber> subscribers = new ConcurrentHashSet<>();

    @Override
    public void init(Class<? extends Event> eventType, int bufferSize) {
        //设置为守护进程
//        setDaemon(true);
        //设置线程名称
        setName("pushlisher-" + eventType.getName());

        //事件队列
        this.queueMaxSize = bufferSize;
        this.queue = new ArrayBlockingQueue<>(bufferSize);

        //启动线程
        start();
    }

    @Override
    public synchronized void start() {
        if (!initialized) {
            super.start();
            initialized = true;
        }
    }


    @Override
    public void run() {

        try {

            for (; ; ) {
                if (shutdown) {
                    break;
                }
                Event event = queue.take();
                receiveEvent(event);
                UPDATER.compareAndSet(this, lastEventSequence, Math.max(lastEventSequence, event.sequence()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean publish(Event event) {
        checkIsStart();
        boolean success = this.queue.offer(event);
        if (!success) {
            //如果放入队列不成功，直接处理
            receiveEvent(event);
        }
        return true;
    }

    /**
     * 通知订阅者
     *
     * @param event
     */
    private void receiveEvent(Event event) {
        long currentSequence = event.sequence();

        if (!hasSubscriber()) {
            LOGGER.warn("[NotifyCenter] the {} is lost, because there is no subscriber.", event);
            return;
        }

        for (Subscriber subscriber : subscribers) {
            if (subscriber.ignoreExpireEvent() && lastEventSequence > currentSequence) {
                LOGGER.debug("[NotifyCenter] the {} is unacceptable to this subscriber, because had expire", event.getClass());
                continue;
            }
            notifySubscriber(subscriber, event);
        }

    }

    @Override
    public void notifySubscriber(Subscriber subscriber, Event event) {
        final Runnable job = () -> subscriber.onEvent(event);

        //选择是同步 执行 还是异步执行
        Executor executor = subscriber.executor();
        if (Objects.isNull(executor)) {
            job.run();
        } else {
            executor.execute(job);
        }
    }

    private boolean hasSubscriber() {
        return subscribers != null && subscribers.size() > 0;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }


    /**
     * 检查是否已经初始化好
     */
    void checkIsStart() {
        if (!initialized) {
            throw new IllegalStateException("Publisher does not start");
        }
    }

}
