package com.wl.strategy;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author 南顾北衫
 */
@Getter
@Setter
public class FormSubmitRequest {
    String type;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 表单提交的值
     */
    private Map<String, Object> formInput;
}
