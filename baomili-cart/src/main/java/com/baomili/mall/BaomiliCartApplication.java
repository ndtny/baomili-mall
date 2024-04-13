package com.baomili.mall;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomili.mall.modules.*.mapper")
public class BaomiliCartApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaomiliCartApplication.class);
    }
}