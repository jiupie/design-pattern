package com.wl.pipline.web;

import com.wl.pipline.service.ModelService;
import com.wl.pipline.service.req.InstanceBuilderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 南顾北衫
 */
@RestController
public class ModelDataController {
    @Resource
    private ModelService modelService;

    @PostMapping("/model")
    public String input() {
        return modelService.buildModelInstance(new InstanceBuilderRequest());
    }
}
