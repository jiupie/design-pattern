package com.wl.pipline.handler;

import com.wl.pipline.ContextHandler;
import com.wl.pipline.InstanceBuildContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 南顾北衫
 */
@Slf4j
@Component
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handler(InstanceBuildContext context) {
        log.info("--根据输入数据创建模型实例--");

        return true;
    }
}
