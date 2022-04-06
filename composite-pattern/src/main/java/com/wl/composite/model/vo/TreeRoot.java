package com.wl.composite.model.vo;

/**
 * @author 南顾北衫
 */
public class TreeRoot {
    /**
     * 规则树Id
     */
    private Long treeId;
    /**
     * 规则树描述
     */
    private String desc;

    /**
     * 树节点Id
     */
    private Long treeNodeId;



    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(Long treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    @Override
    public String toString() {
        return "TreeRoot{" +
                "treeId=" + treeId +
                ", desc='" + desc + '\'' +
                ", treeNodeId=" + treeNodeId +
                '}';
    }
}
