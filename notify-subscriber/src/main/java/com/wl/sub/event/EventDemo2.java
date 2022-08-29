package com.wl.sub.event;

import com.wl.sub.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 南顾北衫
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EventDemo2 extends Event {
    private int age;
}
