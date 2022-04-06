package com.wl;

import java.util.Map;

/**
 * @author 南顾北衫
 */
public class UserGenderFilter extends AbstractBaseLogic{
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
