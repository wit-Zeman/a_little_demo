package com.zeman.springboot.yaml;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/yaml")
public class EnvironmentController {

    // 使用Environment读取yaml，只能读取application.yml这种文件
    @Resource
    private Environment environment;

    @RequestMapping("/environment")
    public String environment() {
        String name = environment.getProperty("person.name", String.class);
        Integer age = environment.getProperty("person.age", Integer.class);
        return "name:" + name + " age:" + age;
    }

    // 使用YamlPropertiesFactoryBean读取yaml
    @RequestMapping("/factory")
    public String factory() {
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("person.yml"));
        Properties properties = yamlPropertiesFactoryBean.getObject();
        properties.forEach((k, v) -> System.out.println(k + ":" + v));
        return "yaml";
    }

    // 使用SnakeYml，引入依赖后可不在Spring环境下使用
    @RequestMapping("/snake")
    public String snake() {
        Yaml yaml=new Yaml();
        Map<String, Object> map =
                yaml.load(getClass().getClassLoader()
                        .getResourceAsStream("person.yml"));
        // 对象
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        return "snake";
    }
}
