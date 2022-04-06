package com.wl.model.vo;

/**
 * 树根信息
 *
 * @author 南顾北衫
 */
public class TreeRoot {
    /**
     * 规则树Id
     */
    private Long treeId;

    /**
     * 规则树根Id
     */
    private Long treeRootNodeId;

    /**
     * 规则树名称
     */
    private String treeName;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeRootNodeId() {
        return treeRootNodeId;
    }


    public void setTreeRootNodeId(Long treeRootNodeId) {
        this.treeRootNodeId = treeRootNodeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }


    @Override
    public String toString() {
        return "TreeRoot{" +
                "treeId=" + treeId +
                ", treeRootNodeId=" + treeRootNodeId +
                ", treeName='" + treeName + '\'' +
                '}';
    }
}
