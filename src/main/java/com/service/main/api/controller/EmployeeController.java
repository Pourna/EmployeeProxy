package com.service.main.api.controller;

import com.service.main.api.dto.Employee;
import com.service.main.api.logic.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    RestTemplate restTemplate = new RestTemplate();
    String employeeDBURL = "http://172.17.0.2:8080/employee";

    @PostMapping("/addEmployee")
    public ResponseEntity<Object> postEmployee(@RequestBody Employee employee) {
        return restTemplate.postForEntity(employeeDBURL, employee, Object.class);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<Employee[]> getAllEmployee() {
        return restTemplate.getForEntity(employeeDBURL, Employee[].class);
    }

    @GetMapping("/getEmployeeWithMaxSalary")
    public List<Employee> getEmployeeWithMaxSalary(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String month) {
        Employee[] employees = restTemplate.getForEntity(employeeDBURL, Employee[].class).getBody();
        List<Employee> employeeList = new ArrayList<>
                (Arrays.asList(Optional.ofNullable(employees).orElse(new Employee[0])));
        List<Employee> result;
        if(year!=null && StringUtils.isNotEmpty(month))
            result = employeeService.getEmployeeWithMaxSalaryBy(employeeList, year, month);
        else if (year != null)
            result = employeeService.getEmployeeWithMaxSalaryBy(employeeList, year);
        else
            result = employeeService.getEmployeeWithMaxSalaryBy(employeeList);
        return result;
    }

    @GetMapping("/getEmployeeCountByPinCode/{pinCode}")
    public String getEmployeeCountByPinCode(@PathVariable Integer pinCode) {
        Employee[] employees = restTemplate.getForEntity(employeeDBURL, Employee[].class).getBody();
        List<Employee> employeeList = new ArrayList<>
                (Arrays.asList(Optional.ofNullable(employees).orElse(new Employee[0])));
        Long count = employeeService.getEmployeeByPinCode(employeeList, pinCode);
        return "Total number of employees residing at pinCode "+pinCode+": "+count;
    }

    @GetMapping("/getEmployeeCountByDistrict")
    public Map<String, Long> getEmployeeCountByDistrict() {
        Employee[] employees = restTemplate.getForEntity(employeeDBURL, Employee[].class).getBody();
        List<Employee> employeeList = new ArrayList<>
                (Arrays.asList(Optional.ofNullable(employees).orElse(new Employee[0])));
        return employeeService.getEmployeeByDistrict(employeeList);
    }

    @GetMapping("/getEmployeeByAgeRange")
    public List<String> getEmployeeByAgeRange(@RequestParam(required = false) Integer start, @RequestParam(required = false) Integer end) {
        Employee[] employees = restTemplate.getForEntity(employeeDBURL, Employee[].class).getBody();
        List<Employee> employeeList = new ArrayList<>
                (Arrays.asList(Optional.ofNullable(employees).orElse(new Employee[0])));
        if (start != null && end != null)
            return employeeService.getEmployeeIdBy(employeeList, start, end);
        else if (start == null && end != null)
            return employeeService.getEmployeeIdBy(employeeList, 1, end);
        else if (start != null)
            return employeeService.getEmployeeIdBy(employeeList, start, 100);
        else
            return employeeService.getEmployeeIdBy(employeeList,1,100);

    }

    @GetMapping("/getEmployeeWithLeastLeaves")
    public List<Employee> getEmployeeWithLeastLeaves() {
        Employee[] employees = restTemplate.getForEntity(employeeDBURL, Employee[].class).getBody();
        List<Employee> employeeList = new ArrayList<>
                (Arrays.asList(Optional.ofNullable(employees).orElse(new Employee[0])));
        employeeService.getEmployeeWithLeastLeave(employeeList);
        return employeeList;
    }
}
