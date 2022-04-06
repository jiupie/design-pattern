package com.wl.composite.engine;

import com.wl.composite.LogicFilter;
import com.wl.composite.UserAgeFilter;
import com.wl.composite.UserSexFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 南顾北衫
 */
public class EngineConfig {
    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userSex", new UserSexFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }
}
