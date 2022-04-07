package com.wl.boot.enums;

public enum BlobEventEnum {

    THROW_COIN(0, "投币"),
    LIKE(10, "点赞"),
    COLLECT(20, "收藏"),
    ;

    /**
     * 枚举编码
     */
    private final int code;

    /**
     * 枚举描述
     */
    private final String value;

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    BlobEventEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

}