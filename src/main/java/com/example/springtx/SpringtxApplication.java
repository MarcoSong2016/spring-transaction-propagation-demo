package com.example.springtx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springtx.mapper")
public class SpringtxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtxApplication.class, args);
    }
}
