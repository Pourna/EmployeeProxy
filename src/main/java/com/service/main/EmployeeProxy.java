package com.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeProxy {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeProxy.class, args);
    }
}
