package com.wl.strategy.impl;

import com.wl.strategy.FormSubmitHandler;
import com.wl.strategy.FormSubmitRequest;
import org.springframework.stereotype.Component;

/**
 * @author 南顾北衫
 */
@Component
public class FromModelSubmitHandler implements FormSubmitHandler {
    @Override
    public String getSubmitType() {
        return "frommodel";
    }

    @Override
    public String handlerSubmit(FormSubmitRequest formSubmitRequest) {
        return "模型处理";
    }
}
