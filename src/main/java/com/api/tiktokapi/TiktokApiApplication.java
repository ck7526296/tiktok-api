package com.api.tiktokapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.api.tiktokapi.mapper")
public class TiktokApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiktokApiApplication.class, args);
    }

}
