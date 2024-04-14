package com.baomili.mall;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 启动时不连接数据库
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.baomili.mall.modules.*.mapper")
@EnableDiscoveryClient
public class BaomiliAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaomiliAdminApplication.class);
    }
}



