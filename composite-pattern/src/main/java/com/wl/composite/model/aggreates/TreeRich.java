package com.wl.composite.model.aggreates;

import com.wl.composite.model.vo.TreeNode;
import com.wl.composite.model.vo.TreeRoot;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 南顾北衫
 */
public class TreeRich implements Serializable {
    private TreeRoot treeRoot;

    private Map<Long, TreeNode> treeNodeMap;


    public TreeRich() {
    }

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
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
        return "TreeRich{" +
                "treeRoot=" + treeRoot +
                ", treeNodeMap=" + treeNodeMap +
                '}';
    }
}
