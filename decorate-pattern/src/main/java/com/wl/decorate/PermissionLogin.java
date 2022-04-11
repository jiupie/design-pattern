package com.wl.decorate;

/**
 * @author 南顾北衫
 */
public class PermissionLogin extends LoginDecorate {

    public PermissionLogin(Intercept intercept) {
        super(intercept);
    }

    @Override
    public boolean handle(String value) {
        boolean handle = super.handle(value);
        if (!handle) {
            return false;
        }

        return value.contains("admin");
    }
}
