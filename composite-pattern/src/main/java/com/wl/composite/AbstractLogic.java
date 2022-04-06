package com.wl.composite;

import com.wl.composite.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * @author 南顾北衫
 */
public abstract class AbstractLogic implements LogicFilter {
    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinks) {
        for (TreeNodeLink treeNodeLink : treeNodeLinks) {
            if (descision(matterValue, treeNodeLink)) {
                return treeNodeLink.getTo();
            }
        }
        return -1L;
    }


    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    private static boolean descision(String matterValue, TreeNodeLink nodeLink) {
        switch (nodeLink.getOperatorEnum()) {
            case EQUALS:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case GREATER:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case LESS:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case LESS_EQUALS:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            case GREATER_EQUALS:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }
    }

}
