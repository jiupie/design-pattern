package com.wl.composite.model.enums;

/**
 * @author 南顾北衫
 */
public enum TreeNodeEnum {
    root(1,"非叶子节点"),
    leaf(2,"叶子节点")
    ;
    private Integer code;
    private String desc;

    TreeNodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
