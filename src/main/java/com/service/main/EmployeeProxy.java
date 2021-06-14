package com.service.main;

import com.service.main.api.dto.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class EmployeeProxy {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeProxy.class, args);
    }
}
