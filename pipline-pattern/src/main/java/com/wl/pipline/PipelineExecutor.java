package com.wl.pipline;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 南顾北衫
 */
@Slf4j
@Component
public class PipelineExecutor {
    @Resource
    private Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>> pipelineRouteMap;

    public Boolean acceptSync(PipelineContext pipelineContext) {
        if (Objects.isNull(pipelineContext)) {
            throw new RuntimeException("");
        }

        //拿到 数据类型
        Class<? extends PipelineContext> classDataType = pipelineContext.getClass();

        List<? extends ContextHandler<? super PipelineContext>> pipelineList = pipelineRouteMap.get(classDataType);

        if (CollectionUtils.isEmpty(pipelineList)) {
            log.error("{}管道为空", classDataType.getSimpleName());
            return false;
        }

        boolean lastSuccess = true;
        for (ContextHandler<? super PipelineContext> contextHandler : pipelineList) {

            try {
                lastSuccess = contextHandler.handler(pipelineContext);
            } catch (Throwable throwable) {
                lastSuccess = false;
                log.error("[{}]处理异常，handler={}", contextHandler.getClass().getSimpleName(), contextHandler.getClass().getSimpleName());
            }
            if(!lastSuccess){
                break;
            }

        }

        return lastSuccess;

    }

}
