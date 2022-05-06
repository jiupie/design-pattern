package com.wl.pipline.service;

import com.wl.pipline.InstanceBuildContext;
import com.wl.pipline.PipelineExecutor;
import com.wl.pipline.service.req.InstanceBuilderRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 南顾北衫
 */
@Service
public class ModelService {
    @Resource
    private PipelineExecutor pipelineExecutor;

    public String buildModelInstance(InstanceBuilderRequest request) {
        InstanceBuildContext data = createPipelineData(request);
        Boolean success = pipelineExecutor.acceptSync(data);
        if (success) {
            return "成功";
        }
        return "fail";
    }

    private InstanceBuildContext createPipelineData(InstanceBuilderRequest request) {
        InstanceBuildContext instanceBuildContext = new  InstanceBuildContext();

        return instanceBuildContext;
    }

}
