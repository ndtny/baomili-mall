package com.baomili.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.baomili.mall.modules.*.mapper")
@EnableDiscoveryClient
public class BaomiliOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaomiliOrderApplication.class);
    }
}