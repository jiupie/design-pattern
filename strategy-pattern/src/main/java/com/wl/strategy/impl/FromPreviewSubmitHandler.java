package com.wl.strategy.impl;

import com.wl.strategy.FormSubmitHandler;
import com.wl.strategy.FormSubmitRequest;
import org.springframework.stereotype.Component;

/**
 * @author 南顾北衫
 */
@Component
public class FromPreviewSubmitHandler implements FormSubmitHandler {
    @Override
    public String getSubmitType() {
        return "preview";
    }

    @Override
    public String handlerSubmit(FormSubmitRequest formSubmitRequest) {
        return "预览模式处理";
    }
}
