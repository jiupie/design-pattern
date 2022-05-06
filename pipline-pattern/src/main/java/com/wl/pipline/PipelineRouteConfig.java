package com.wl.pipline;

import com.wl.pipline.handler.InputDataPreChecker;
import com.wl.pipline.handler.ModelInstanceCreator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 管道路由配置
 *
 * @author 南顾北衫
 */
@Configuration
public class PipelineRouteConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    /**
     * 数据类型-》管道中处理器类型列表的路由
     */
    private static final Map<Class<? extends PipelineContext>, List<Class<? extends ContextHandler<? extends PipelineContext>>>> PIPELINE_ROUTE_MAP = new HashMap<>(4);

    static {
        PIPELINE_ROUTE_MAP.put(InstanceBuildContext.class, Arrays.asList(InputDataPreChecker.class, ModelInstanceCreator.class));
    }

    @Bean("pipelineRouteMap")
    public Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>> getHandlerPipelineMap(){
        return PIPELINE_ROUTE_MAP.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, this::toPipeLine));
    }

    private List<? extends ContextHandler<? extends PipelineContext>> toPipeLine(Map.Entry<Class<? extends PipelineContext>, List<Class<? extends ContextHandler<? extends PipelineContext>>>> entry) {
        return entry.getValue().stream().map(applicationContext::getBean).collect(Collectors.toList());
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
