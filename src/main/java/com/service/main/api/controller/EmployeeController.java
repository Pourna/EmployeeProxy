package com.service.main.api.controller;

import com.service.main.api.client.EmployeeClient;
import com.service.main.api.dto.Employee;
import com.service.main.api.logic.EmployeeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@EnableFeignClients
public class EmployeeController {

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public void postEmployee(@RequestBody Employee employee) {
        employeeClient.addEmployee(employee);
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return employeeClient.getAllEmployee();
    }

    @GetMapping("/getEmployeeWithMaxSalary")
    public List<Employee> getEmployeeWithMaxSalary(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String month) {
        List<Employee> employeeList = employeeClient.getAllEmployee();
        List<Employee> result;
        if(year!=null && StringUtils.isNotEmpty(month))
            result = employeeService.getEmployeeWithMaxSalaryBy(employeeList, year, month);
        else if (year != null)
            result = employeeService.getEmployeeWithMaxSalaryBy(employeeList, year);
        else
            result = employeeService.getEmployeeWithMaxSalaryBy(employeeList);
        return result;
    }

    @GetMapping("/getEmployeeCountByPincode/{pinCode}")
    public String getEmployeeCountByPinCode(@PathVariable Integer pinCode) {
        List<Employee> employeeList = employeeClient.getAllEmployee();
        Long count = employeeService.getEmployeeByPinCode(employeeList, pinCode);
        return "Total number of employees residing at pincode "+pinCode+": "+count;
    }

    @GetMapping("/getEmployeeCountByDistrict")
    public Map<String, Long> getEmployeeCountByDistrict() {
        List<Employee> employeeList = employeeClient.getAllEmployee();
        return employeeService.getEmployeeByDistrict(employeeList);
    }

    @GetMapping("/getEmployeeByAgeRange")
    public List<String> getEmployeeByAgeRange(@RequestParam(required = false) Integer start, @RequestParam(required = false) Integer end) {
        List<Employee> employeeList = employeeClient.getAllEmployee();
        if (start != null && end != null)
            return employeeService.getEmployeeIdBy(employeeList, start, end);
        else if (start == null && end != null)
            return employeeService.getEmployeeIdBy(employeeList, 1, end);
        else if (start != null && end == null)
            return employeeService.getEmployeeIdBy(employeeList, start, 100);
        else
            return employeeService.getEmployeeIdBy(employeeList,1,100);

    }

    @GetMapping("/getEmployeeWithLeastLeaves")
    public List<Employee> getEmployeeWithLeastLeaves() {
        List<Employee> employeeList = employeeClient.getAllEmployee();
        employeeService.getEmployeeWithLeastLeave(employeeList);
        return employeeList;
    }
}
