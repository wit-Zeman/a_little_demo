package com.zeman.saToken.role.controller;

import cn.dev33.satoken.annotation.*;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 注解鉴权
 */
@RestController
@RequestMapping("/annotation/")
public class AnnotationController {

    // 查看用户角色与权限
    @RequestMapping("check")
    public String check() {
        List<String> permissionList = StpUtil.getPermissionList();
        List<String> roleList = StpUtil.getRoleList();
        StringBuilder sb = new StringBuilder();
        sb.append("权限列表：").append(permissionList).append(" ");
        sb.append("角色列表：").append(roleList);
        return sb.toString();
    }

    // 登录校验：只有登录之后才能进入该方法
    @SaCheckLogin
    @RequestMapping("info")
    public String info() {
        return "查询用户信息";
    }

    // 角色校验：必须具有指定角色才能进入该方法
    @SaCheckRole("super-admin")
    @RequestMapping("role")
    public String role() {
        return "用户增加";
    }

    // 权限校验：必须具有指定权限才能进入该方法
    @SaCheckPermission("user::add")
    @RequestMapping("permission")
    public String permission() {
        return "用户增加";
    }


}
