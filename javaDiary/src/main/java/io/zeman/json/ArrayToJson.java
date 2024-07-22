package io.zeman.json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeman
 * @date 2024/7/22
 * @className ArrayToJson
 */
public class ArrayToJson {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 18));
        users.add(new User("李四", 19));
        System.out.println(JSON.toJSONString(users));
    }
}
