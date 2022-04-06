package com.wl.composite.engine;

import com.wl.composite.engine.vo.EngineResult;
import com.wl.composite.model.aggreates.TreeRich;
import com.wl.composite.model.vo.TreeNode;

import java.util.Map;

/**
 * @author 南顾北衫
 */
public class TreeEngineHandler extends EngineBase {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getRuleValue());
    }


}
