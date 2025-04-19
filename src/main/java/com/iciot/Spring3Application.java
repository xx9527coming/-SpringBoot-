package com.iciot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iciot.dao")
public class Spring3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring3Application.class, args);
    }

}
