package com.service.main.api.client;

import com.service.main.api.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(url="http://localhost:8080", name="EmployeeProxy")
public interface EmployeeClient {

    @GetMapping("/employee")
    public List<Employee> getAllEmployee();

    @PostMapping("/employee")
    void addEmployee(Employee employee);
}