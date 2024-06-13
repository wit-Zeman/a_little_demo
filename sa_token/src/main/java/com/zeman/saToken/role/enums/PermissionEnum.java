package com.zeman.saToken.role.enums;


import lombok.Getter;


/**
 * 权限枚举
 */
@Getter
public enum PermissionEnum {

    // 操作权限
    USER_ADD(1, "user::add"),
    USER_DELETE(2, "user::delete"),
    USER_UPDATE(3, "user::update"),
    USER_QUERY(4, "user::query"),
    USER_ALL(5, "user::*");

    private Integer code;

    private String value;

    PermissionEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

}
