package com.zeman.saToken;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class SaTokenApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        jdbcTemplate.query("select * from t_user", (rs, rowNum) -> {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
            System.out.println(rs.getString("role"));
            return null;
        });
    }

}
