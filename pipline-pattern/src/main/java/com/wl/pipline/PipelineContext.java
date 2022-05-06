package com.wl.pipline;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author 南顾北衫
 */
@Getter
@Setter
public class PipelineContext {
    /**
     * 处理开始时间
     */
    private LocalDateTime startTime;

    /**
     * 处理结束时间
     */
    private LocalDateTime endTime;

    public String getName(){
        return this.getClass().getSimpleName();
    }
}
