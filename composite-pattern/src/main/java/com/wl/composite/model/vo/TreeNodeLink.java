package com.wl.composite.model.vo;

import com.wl.composite.model.enums.OperatorEnum;

/**
 * @author 南顾北衫
 */
public class TreeNodeLink {
    private Long from;
    private Long to;

    private OperatorEnum operatorEnum;

    private String ruleLimitValue;

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public void setRuleLimitValue(String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }

    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    public OperatorEnum getOperatorEnum() {
        return operatorEnum;
    }

    public void setOperatorEnum(OperatorEnum operatorEnum) {
        this.operatorEnum = operatorEnum;
    }

    @Override
    public String toString() {
        return "TreeNodeLink{" +
                "from=" + from +
                ", to=" + to +
                ", operatorEnum=" + operatorEnum +
                ", ruleLimitValue='" + ruleLimitValue + '\'' +
                '}';
    }
}
