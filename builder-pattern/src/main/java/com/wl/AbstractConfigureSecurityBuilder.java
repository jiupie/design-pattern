package com.wl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/9/1
 */
public abstract class AbstractConfigureSecurityBuilder<O, B extends SecurityBuilder<O>> extends AbstractBuilderConfigure<O> {

    private final LinkedHashMap<Class<? extends SecurityBuilderConfigurer<O, B>>, List<? extends SecurityBuilderConfigurer<O, B>>> configurers = new LinkedHashMap<>();

    private BuildState buildState = BuildState.UNBUILT;

    private final List<SecurityBuilderConfigurer<O, B>> configurersAddedInInitializing = new ArrayList<>();


    @Override
    protected O doBuild() {
        synchronized (configurers) {
            //初始化
            this.buildState = BuildState.INITIALIZING;
            beforeInit();
            init();

            //配置
            this.buildState = BuildState.CONFIGURING;
            beforeConfigure();
            configure();

            //构建中
            this.buildState = BuildState.BUILDING;
            O result = perfromBuild();

            //构建完成
            this.buildState = BuildState.BUILT;
            return result;
        }
    }

    protected abstract O perfromBuild();

    private void configure() {
        Collection<SecurityBuilderConfigurer<O, B>> configurers = getConfigures();
        for (SecurityBuilderConfigurer<O, B> configurer : configurers) {
            configurer.configure((B) this);
        }
    }

    private void beforeConfigure() {

    }

    private void beforeInit() {

    }

    private void init() {
        Collection<SecurityBuilderConfigurer<O, B>> configurers = getConfigures();
        for (SecurityBuilderConfigurer<O, B> configurer : configurers) {
            configurer.init((B) this);
        }
        for (SecurityBuilderConfigurer<O, B> configurer : this.configurersAddedInInitializing) {
            configurer.init((B) this);
        }
    }

    private List<SecurityBuilderConfigurer<O, B>> getConfigures() {
        ArrayList<SecurityBuilderConfigurer<O, B>> list = new ArrayList<>();
        for (List<? extends SecurityBuilderConfigurer<O, B>> value : this.configurers.values()) {
            list.addAll(value);
        }
        return list;
    }


    enum BuildState {
        UNBUILT(0),
        INITIALIZING(1),
        CONFIGURING(2),
        BUILDING(3),
        BUILT(4);


        private final int order;

        BuildState(int order) {
            this.order = order;
        }

        public boolean isInitializing() {
            return INITIALIZING.order == this.order;
        }
    }
}
