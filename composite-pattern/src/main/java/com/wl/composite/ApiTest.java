package com.wl.composite;

import com.wl.composite.engine.IEngine;
import com.wl.composite.engine.TreeEngineHandler;
import com.wl.composite.engine.vo.EngineResult;
import com.wl.composite.model.aggreates.TreeRich;
import com.wl.composite.model.enums.OperatorEnum;
import com.wl.composite.model.enums.TreeNodeEnum;
import com.wl.composite.model.vo.TreeNode;
import com.wl.composite.model.vo.TreeNodeLink;
import com.wl.composite.model.vo.TreeRoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 南顾北衫
 */
public class ApiTest {
    private static Logger logger = LoggerFactory.getLogger(ApiTest.class);

    public static void main(String[] args) {
        TreeRich treeRich = init();
        logger.info("决策树组合结构信息：\r\n" + treeRich);

        IEngine treeEngineHandle = new TreeEngineHandler();
        Map<String, String> decisionMatter = new HashMap<>();
        decisionMatter.put("userSex", "woman");
        decisionMatter.put("userAge", "21");

        EngineResult result = treeEngineHandle.process(10001L, "Oli09pLkdjh", treeRich, decisionMatter);
//        boolean success = result.isSuccess();
        logger.info("测试结果：{}", result);
    }

    public static TreeRich init() {
        // 节点：1
        TreeNode treeNode_01 = new TreeNode();
        treeNode_01.setTreeId(10001L);
        treeNode_01.setTreeNodeId(1L);
        treeNode_01.setType(TreeNodeEnum.root);
        treeNode_01.setRuleValue(null);
        treeNode_01.setRuleKey("userSex");
        treeNode_01.setDesc("用户性别[男/女]");

        // 链接：1->11
        TreeNodeLink treeNodeLink_11 = new TreeNodeLink();
        treeNodeLink_11.setFrom(1L);
        treeNodeLink_11.setTo(11L);
        treeNodeLink_11.setOperatorEnum(OperatorEnum.EQUALS);
        treeNodeLink_11.setRuleLimitValue("man");

        // 链接：1->12
        TreeNodeLink treeNodeLink_12 = new TreeNodeLink();
        treeNodeLink_12.setFrom(1L);
        treeNodeLink_12.setTo(12L);
        treeNodeLink_12.setOperatorEnum(OperatorEnum.EQUALS);
        treeNodeLink_12.setRuleLimitValue("woman");

        List<TreeNodeLink> treeNodeLinkList_1 = new ArrayList<>();
        treeNodeLinkList_1.add(treeNodeLink_11);
        treeNodeLinkList_1.add(treeNodeLink_12);

        treeNode_01.setTreeNodeLinks(treeNodeLinkList_1);

        // 节点：11
        TreeNode treeNode_11 = new TreeNode();
        treeNode_11.setTreeId(10001L);
        treeNode_11.setTreeNodeId(11L);
        treeNode_11.setType(TreeNodeEnum.root);
        treeNode_11.setRuleValue(null);
        treeNode_11.setRuleKey("userAge");
        treeNode_11.setDesc("用户年龄");

        // 链接：11->111
        TreeNodeLink treeNodeLink_111 = new TreeNodeLink();
        treeNodeLink_111.setFrom(11L);
        treeNodeLink_111.setTo(111L);
        treeNodeLink_111.setOperatorEnum(OperatorEnum.LESS);
        treeNodeLink_111.setRuleLimitValue("25");

        // 链接：11->112
        TreeNodeLink treeNodeLink_112 = new TreeNodeLink();
        treeNodeLink_112.setFrom(11L);
        treeNodeLink_112.setTo(112L);
        treeNodeLink_112.setOperatorEnum(OperatorEnum.GREATER_EQUALS);
        treeNodeLink_112.setRuleLimitValue("25");

        List<TreeNodeLink> treeNodeLinkList_11 = new ArrayList<>();
        treeNodeLinkList_11.add(treeNodeLink_111);
        treeNodeLinkList_11.add(treeNodeLink_112);
        treeNode_11.setTreeNodeLinks(treeNodeLinkList_11);

        // 节点：12
        TreeNode treeNode_12 = new TreeNode();
        treeNode_12.setTreeId(10001L);
        treeNode_12.setTreeNodeId(12L);
        treeNode_12.setType(TreeNodeEnum.root);
        treeNode_12.setRuleValue(null);
        treeNode_12.setRuleKey("userAge");
        treeNode_12.setDesc("用户年龄");

        // 链接：12->121
        TreeNodeLink treeNodeLink_121 = new TreeNodeLink();
        treeNodeLink_121.setFrom(12L);
        treeNodeLink_121.setTo(121L);
        treeNodeLink_121.setOperatorEnum(OperatorEnum.LESS);
        treeNodeLink_121.setRuleLimitValue("25");

        // 链接：12->122
        TreeNodeLink treeNodeLink_122 = new TreeNodeLink();
        treeNodeLink_122.setFrom(12L);
        treeNodeLink_122.setTo(122L);
        treeNodeLink_122.setOperatorEnum(OperatorEnum.GREATER_EQUALS);
        treeNodeLink_122.setRuleLimitValue("25");

        List<TreeNodeLink> treeNodeLinkList_12 = new ArrayList<>();
        treeNodeLinkList_12.add(treeNodeLink_121);
        treeNodeLinkList_12.add(treeNodeLink_122);
        treeNode_12.setTreeNodeLinks(treeNodeLinkList_12);

        // 节点：111
        TreeNode treeNode_111 = new TreeNode();
        treeNode_111.setTreeId(10001L);
        treeNode_111.setTreeNodeId(111L);
        treeNode_111.setType(TreeNodeEnum.leaf);
        treeNode_111.setRuleValue("果实A");

        // 节点：112
        TreeNode treeNode_112 = new TreeNode();
        treeNode_112.setTreeId(10001L);
        treeNode_112.setTreeNodeId(112L);
        treeNode_112.setType(TreeNodeEnum.leaf);
        treeNode_112.setRuleValue("果实B");

        // 节点：121
        TreeNode treeNode_121 = new TreeNode();
        treeNode_121.setTreeId(10001L);
        treeNode_121.setTreeNodeId(121L);
        treeNode_121.setType(TreeNodeEnum.leaf);
        treeNode_121.setRuleValue("果实C");

        // 节点：122
        TreeNode treeNode_122 = new TreeNode();
        treeNode_122.setTreeId(10001L);
        treeNode_122.setTreeNodeId(122L);
        treeNode_122.setType(TreeNodeEnum.leaf);
        treeNode_122.setRuleValue("果实D");

        // 树根
        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(10001L);
        treeRoot.setTreeId(1L);
        treeRoot.setDesc("规则决策树");
        Map<Long, TreeNode> treeNodeMap = new HashMap<>();
        treeNodeMap.put(1L, treeNode_01);
        treeNodeMap.put(11L, treeNode_11);
        treeNodeMap.put(12L, treeNode_12);
        treeNodeMap.put(111L, treeNode_111);
        treeNodeMap.put(112L, treeNode_112);
        treeNodeMap.put(121L, treeNode_121);
        treeNodeMap.put(122L, treeNode_122);

        return new TreeRich(treeRoot, treeNodeMap);
    }
}
