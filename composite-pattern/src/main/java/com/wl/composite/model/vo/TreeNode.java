package com.wl.composite.model.vo;

import com.wl.composite.model.enums.TreeNodeEnum;

import java.util.List;

/**
 * @author 南顾北衫
 */
public class TreeNode {
    private Long treeId;

    /**
     * 节点Id
     */
    private Long treeNodeId;

    private TreeNodeEnum type;

    private String ruleKey;

    private String ruleValue;

    private List<TreeNodeLink> treeNodeLinks;

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(Long treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public TreeNodeEnum getType() {
        return type;
    }

    public void setType(TreeNodeEnum type) {
        this.type = type;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public List<TreeNodeLink> getTreeNodeLinks() {
        return treeNodeLinks;
    }

    public void setTreeNodeLinks(List<TreeNodeLink> treeNodeLinks) {
        this.treeNodeLinks = treeNodeLinks;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "treeId=" + treeId +
                ", treeNodeId=" + treeNodeId +
                ", type=" + type +
                ", ruleKey='" + ruleKey + '\'' +
                ", ruleValue='" + ruleValue + '\'' +
                ", treeNodeLinks=" + treeNodeLinks +
                ", desc='" + desc + '\'' +
                '}';
    }
}
