package com.wl.sub.subscribe;

import com.wl.sub.Event;
import com.wl.sub.Subscriber;
import com.wl.sub.event.EventDemo;
import com.wl.sub.event.EventDemo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南顾北衫
 */
public class SubscribeDemo extends Subscriber<EventDemo>{
    @Override
    public void onEvent(Event event) {
        System.out.println(event);
    }

    @Override
    public List<Class<? extends Event>> subscribeTypes() {
        List<Class<? extends Event>> list = new ArrayList<>();
        list.add(EventDemo.class);
        list.add(EventDemo1.class);
        return list;
    }


}
