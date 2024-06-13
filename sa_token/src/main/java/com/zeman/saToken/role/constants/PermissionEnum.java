package com.zeman.saToken.role.constants;

public final class PermissionEnum {

    // 权限常量
    public static final String USER_ADD_PERMISSION = "user::add";
    public static final String USER_DELETE_PERMISSION = "user::delete";
    public static final String USER_UPDATE_PERMISSION = "user::update";
    public static final String USER_QUERY_PERMISSION = "user::query";
    public static final String USER_ALL_PERMISSION = "user::*";

    // 防止实例化
    private PermissionEnum() {
    }
}

