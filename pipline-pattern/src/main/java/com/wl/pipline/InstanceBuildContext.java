package com.wl.pipline;

import java.util.Map;

/**
 * @author 南顾北衫
 */
public class InstanceBuildContext extends PipelineContext {
    /**
     * 模型Id
     */
    private Long modelId;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 表单输入
     */
    private Map<String, Object> formInput;

    /**
     * 保存模型实例完成后，记录Id
     */
    private Long instanceId;

    /**
     * 模型创建出错时的错误信息
     */
    private String errorMsg;

    @Override
    public String getName() {
        return "模型实例构建上下文";
    }
}
