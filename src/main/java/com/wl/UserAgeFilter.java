package com.wl;

import com.wl.AbstractBaseLogic;

import java.util.Map;

/**
 * @author 南顾北衫
 */
public class UserAgeFilter extends AbstractBaseLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}