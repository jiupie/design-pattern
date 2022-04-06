package com.wl.composite.model.enums;

/**
 * @author 南顾北衫
 */
public enum OperatorEnum {
    EQUALS(0, "等于"),
    LESS_EQUALS(1, "小于等于"),
    GREATER_EQUALS(2, "大于等于"),
    GREATER(3, "大于"),
    LESS(4,"小于");

    private Integer code;

    private String desc;

    OperatorEnum(Integer code, String desc) {
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
