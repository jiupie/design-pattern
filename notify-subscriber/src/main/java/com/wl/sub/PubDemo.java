package com.wl.sub;

import com.wl.sub.event.EventDemo;
import com.wl.sub.event.EventDemo1;
import com.wl.sub.subscribe.SubscribeDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 南顾北衫
 */
public class PubDemo {
    public static void main(String[] args) {
        SubscribeDemo subscribeDemo = new SubscribeDemo();
        NotifyCenter.registerSubscriber(subscribeDemo);
        AtomicInteger atomicInteger = new AtomicInteger(0);

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(500);
                    EventDemo eventDemo = new EventDemo();
                    eventDemo.setName("s" + atomicInteger.incrementAndGet());
                    EventDemo1 eventDemo1 = new EventDemo1();
                    eventDemo1.setAge(i+ atomicInteger.get());
                    NotifyCenter.publishEvent(eventDemo);
                    NotifyCenter.publishEvent(eventDemo1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
