package com.baomili.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomili.mall.modules.*.mapper")
public class BaomiliProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaomiliProductApplication.class);
    }
}