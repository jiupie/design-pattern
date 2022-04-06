package com.wl.composite;

import java.util.Map;

/**
 * @author 南顾北衫
 */
public class UserAgeFilter extends AbstractLogic{
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("userAge");
    }
}
