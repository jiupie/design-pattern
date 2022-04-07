package com.wl.boot.enums;

/**
 * @author 南顾北衫
 */
public enum UpStateEnum {

    UP_SOMETIMES_STATE(0,"sometimes"),
    UP_OFTEN_STATE(10,"often"),
    UP_USUALLY_STATE(20,"usually"),
    UP_ALWAYS_STATE(30,"always"),
    ;
    private int code;
    private String value;

    UpStateEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
