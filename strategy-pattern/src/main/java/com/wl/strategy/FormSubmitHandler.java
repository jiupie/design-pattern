package com.wl.strategy;

/**
 * @author 南顾北衫
 */
public interface FormSubmitHandler {
    /**
     * 获取提交类型 （返回值也可以使用枚举类型）
     *
     * @return 提交类型
     */
    String getSubmitType();


    /**
     * 处理表单请求
     *
     * @param formSubmitRequest /
     * @return /
     */
    String handlerSubmit(FormSubmitRequest formSubmitRequest);
}
