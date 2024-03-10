package com.baomili.mall;

import com.baomili.mall.modules.admin.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class BaomiliAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaomiliAdminApplication.class);
    }
}