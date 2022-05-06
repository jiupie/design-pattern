package com.wl.strategy.web;

import com.wl.strategy.FormSubmitHandler;
import com.wl.strategy.FormSubmitRequest;
import com.wl.strategy.FromSubmitHandlerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 演示该设计模式没有使用service层
 *
 * @author 南顾北衫
 */
@RestController
public class FormController {
    @Resource
    private FromSubmitHandlerFactory fromSubmitHandlerFactory;


    @GetMapping("/form")
    public String get(@RequestBody FormSubmitRequest formSubmitRequest) {
        FormSubmitHandler handler = fromSubmitHandlerFactory.getHandler(formSubmitRequest.getType());
        return handler.handlerSubmit(formSubmitRequest);
    }

}
