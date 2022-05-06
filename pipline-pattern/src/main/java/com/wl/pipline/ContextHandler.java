package com.wl.pipline;

/**
 * 管道中的上下文处理器
 *
 * @author 南顾北衫
 */
public interface ContextHandler<T extends PipelineContext> {
    /**
     * 处理输入的上下文数据
     *
     * @param context 处理时的上下文数据
     * @return 返回true
     */
    boolean handler(T context);
}
