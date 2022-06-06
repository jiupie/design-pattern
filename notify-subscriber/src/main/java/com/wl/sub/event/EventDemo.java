package com.wl.sub.event;

import com.wl.sub.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 南顾北衫
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EventDemo extends Event {
    private String name;
}
