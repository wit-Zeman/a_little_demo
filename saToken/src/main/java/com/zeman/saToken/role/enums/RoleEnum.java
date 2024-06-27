package com.zeman.saToken.role.enums;

import lombok.Getter;

/**
 * 角色枚举
 */
@Getter
public enum RoleEnum {

    ADMIN(0, "admin"),
    USER(1, "user");

    private Integer code;

    private String value;

    RoleEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
