package com.zeman.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Zeman
 * @date 2024/7/3
 * @className Main8001
 */
@SpringBootApplication
@MapperScan("com.zeman.cloud.mapper")
public class Main8001 {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Main8001.class, args);
    }
}
