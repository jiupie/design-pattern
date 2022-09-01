package com.wl;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/9/1
 */
public abstract class AbstractBuilderConfigure<O> implements SecurityBuilder<O> {
    private AtomicBoolean building = new AtomicBoolean();

    private O object;

    @Override
    public O build() {
        if (building.compareAndSet(false, true)) {
            this.object = doBuild();
            return this.object;
        }
        throw new RuntimeException("已经在构建中");
    }

    public final O getObject() {
        if (!building.get()) {
            throw new IllegalStateException("当前正在构建");
        }
        return this.object;
    }

    protected abstract O doBuild();
}
