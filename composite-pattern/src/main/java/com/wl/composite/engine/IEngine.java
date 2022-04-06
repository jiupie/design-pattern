package com.wl.composite.engine;

import com.wl.composite.model.aggreates.TreeRich;
import com.wl.composite.engine.vo.EngineResult;

import java.util.Map;

/**
 * @author 南顾北衫
 */
public interface IEngine {
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
