package com.database.bpo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class BpoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BpoApplication.class, args);
    }

}
