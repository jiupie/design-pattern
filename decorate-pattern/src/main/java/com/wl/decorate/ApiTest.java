package com.wl.decorate;

/**
 * @author 南顾北衫
 */
public class ApiTest {
    public static void main(String[] args) {
        PermissionLogin permissionLogin = new PermissionLogin(new SSoLogin());
        System.out.println(permissionLogin.handle("a"));
    }
}
