package com.wl;

import com.wl.model.aggreates.TreeRich;
import com.wl.model.vo.EngineResult;

import java.util.Map;

public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}