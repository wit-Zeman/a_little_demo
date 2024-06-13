package com.zeman.saToken.role.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.zeman.saToken.role.pojo.User;
import com.zeman.saToken.role.constants.PermissionEnum;


import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;




@RestController
@RequestMapping("/userPractice")
public class UserPracticeController {


    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/doLogin")
    public String doLogin(@RequestBody User command) {
        User user = getUser(command.getUsername());
        if (Objects.isNull(user)){
            return "用户不存在";
        }
        StpUtil.login(user.getId());
        StpUtil.getSession().set("user", user);
        return "当前登录用户角色：" + StpUtil.getRoleList() + "，当前登录用户权限：" + StpUtil.getPermissionList();
    }


    // 查询操作 先登录
    @SaCheckLogin
    @SaCheckPermission(PermissionEnum.USER_QUERY_PERMISSION)
    @RequestMapping("/query")
    public String get(){
        return "query";
    }

    // 新增操作 先登录
    @SaCheckLogin
    @SaCheckPermission(PermissionEnum.USER_ADD_PERMISSION)
    @RequestMapping("/add")
    public String add(){
        return "add";
    }



    private User getUser(String username) {
        return jdbcTemplate.queryForObject("select * from t_user where username = ?",
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getInt("role"));
                    return user;
                }, username);
    }
}
