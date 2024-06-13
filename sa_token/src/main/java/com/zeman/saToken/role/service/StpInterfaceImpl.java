package com.zeman.saToken.role.service;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.zeman.saToken.role.pojo.User;
import com.zeman.saToken.role.constants.PermissionEnum;
import com.zeman.saToken.role.constants.RoleConstants;
import com.zeman.saToken.role.enums.RoleEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



/**
 * 自定义权限加载接口实现类
 */
@Component
public class StpInterfaceImpl implements StpInterface {


    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        User user = getUserFromContext(); // 新增方法来安全地从上下文中获取用户
        if (user == null) {
            return Collections.emptyList(); // 或者根据实际情况抛出异常
        }

        List<String> permList = new ArrayList<>();
        if (isAdmin(user)) {
            permList.addAll(Arrays.asList(
                    PermissionEnum.USER_ADD_PERMISSION,
                    PermissionEnum.USER_DELETE_PERMISSION,
                    PermissionEnum.USER_UPDATE_PERMISSION,
                    PermissionEnum.USER_QUERY_PERMISSION
            ));
        } else if (isUser(user)) {
            permList.add(PermissionEnum.USER_QUERY_PERMISSION);
        }
        return permList;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        User user = getUserFromContext();
        if (user == null) {
            return Collections.emptyList(); // 或者根据实际情况抛出异常
        }

        List<String> roleList = new ArrayList<>();
        if (isAdmin(user)) {
            roleList.add(RoleConstants.ADMIN_ROLE);
        } else if (isUser(user)) {
            roleList.add(RoleConstants.USER_ROLE);
        }
        return roleList;
    }

    // 新增辅助方法
    private User getUserFromContext() {
        // 假设有一个更安全的方法来获取当前登录的User对象
        // 请根据实际使用的框架或库进行调整
        return (User) StpUtil.getSession().get("user");
    }

    private boolean isAdmin(User user) {
        return RoleEnum.ADMIN.getCode().equals(user.getRole());
    }

    private boolean isUser(User user) {
        return RoleEnum.USER.getCode().equals(user.getRole());
    }
}
