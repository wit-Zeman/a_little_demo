package com.zeman.saToken.role.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.zeman.saToken.role.enums.PermissionEnum.USER_ADD;


@RestController
@RequestMapping("/permission/")
public class PermissionController {

    // http://localhost:8081/permission/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            // setCookie() satoken
            StpUtil.login(10001);
            List<String> permissionList = StpUtil.getPermissionList();
            permissionList.forEach(System.out::println);
            List<String> roleList = StpUtil.getRoleList();
            roleList.forEach(System.out::println);
            return "登录成功";
        }
        return "登录失败";
    }

    @RequestMapping("add")
    public String add() {
        List<String> permissionList = StpUtil.getPermissionList();
        permissionList.forEach(System.out::println);
        return StpUtil.hasPermission(USER_ADD.getValue()) ? "添加成功" : "添加失败";
    }
}
