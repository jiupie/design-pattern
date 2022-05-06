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
public class InputDataPreChecker implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handler(InstanceBuildContext context) {
        log.info("--输入数据校验--");
        return true;
    }
}
