package com.wl.sub;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author 南顾北衫
 */
public abstract class Subscriber<T extends Event> {

    /**
     * 事件处理
     *
     * @param event 事件
     */
    public abstract void onEvent(Event event);

    public abstract List<Class<? extends Event>> subscribeTypes();

    /**
     * 可以设置同步或者异步发布事件给消费者
     *
     * @return /
     */
    public Executor executor() {
        return null;
    }


    /**
     * 是否忽略过期事件
     *
     * @return /
     */
    public boolean ignoreExpireEvent() {
        return false;
    }
}
