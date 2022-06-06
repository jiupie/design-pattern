package com.wl.sub;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 南顾北衫
 */
public abstract class Event {
    private static final AtomicLong SEQUENCE = new AtomicLong(0);

    private final long sequence = SEQUENCE.getAndIncrement();

    /**
     * 唯一序列
     * @return
     */
    public long sequence() {
        return sequence;
    }
}
