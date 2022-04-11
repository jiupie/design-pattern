package com.wl.decorate;

/**
 * @author 南顾北衫
 */
public abstract class LoginDecorate implements Intercept {
    private Intercept intercept;


    public LoginDecorate(Intercept intercept) {
        this.intercept = intercept;
    }

    @Override
    public boolean handle(String value) {
        return this.intercept.handle(value);
    }
}
