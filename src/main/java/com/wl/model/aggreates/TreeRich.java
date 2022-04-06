package com.wl.model.aggreates;

import com.wl.model.vo.TreeNode;
import com.wl.model.vo.TreeRoot;

import java.util.Map;

/**
 * 聚合对象，包含组织树信息
 *
 * @author 南顾北衫
 */
public class TreeRich {
    /**
     * 树根信息
     */
    private TreeRoot treeRoot;
    /**
     * 树节点ID -> 子节点
     */
    private Map<Long, TreeNode> treeNodeMap;

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap=treeNodeMap;
        this.treeRoot=treeRoot;
    }


    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNode> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }

    @Override
    public String toString() {
        return "TreeRich{" + "treeRoot=" + treeRoot + ", treeNodeMap=" + treeNodeMap + '}';
    }
}
