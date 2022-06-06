package com.wl.sub;

import java.util.function.BiFunction;

/**
 * @author 南顾北衫
 */
public interface EventPublisherFactory extends BiFunction<Class<? extends Event>, Integer, EventPublisher> {
    @Override
    EventPublisher apply(Class<? extends Event> eventType, Integer maxQueueSize);
}
