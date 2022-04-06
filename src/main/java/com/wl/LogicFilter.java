package com.wl;

import com.wl.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * @author 南顾北衫
 */
public interface LogicFilter {
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinks);

    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
