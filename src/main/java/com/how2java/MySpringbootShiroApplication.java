package com.how2java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.how2java.mapper")
public class MySpringbootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootShiroApplication.class, args);
    }

}
