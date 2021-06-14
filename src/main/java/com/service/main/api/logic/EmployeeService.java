package com.service.main.api.logic;

import com.service.main.api.dto.Employee;
import com.service.main.api.dto.Leave;
import com.service.main.api.dto.Salary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    public List<Employee> getEmployeeWithLeastLeave(List<Employee> employeeList) {
        HashMap<String, Double> empLeaves= new HashMap<>();
        employeeList.forEach(f->empLeaves.put(f.getId(), f.getLeaves().stream().mapToDouble(Leave::getNoOfDays).sum()));
        Double min = Collections.min(empLeaves.values());
        for(Map.Entry<String, Double> e : empLeaves.entrySet()){
            if(e.getValue()!=min){
                employeeList.remove(employeeList.stream().filter(f-> f.getId()==e.getKey()).findFirst().get());
            }
        }
        return employeeList;
    }

    public Long getEmployeeByPinCode(List<Employee> employeeList, Integer pinCode) {
        return employeeList.stream()
                .filter(f->f.getCurrentAddress() !=null && f.getCurrentAddress().getPinCode().equals(pinCode))
                .count();
    }

    public Map<String, Long> getEmployeeByDistrict(List<Employee> employeeList) {
         Map<String, Long> emap = employeeList.stream().filter(e->e.getCurrentAddress()!=null).collect(Collectors.groupingBy(e->e.getCurrentAddress().getDistrict(), Collectors.counting()));
         return emap;
    }

    public List<String> getEmployeeIdBy(List<Employee> employeeList, Integer start, Integer end) {
        return employeeList.stream()
                .filter(f-> f.getAge()>=start && f.getAge()<=end)
                .flatMap(e-> Stream.of(e.getId()))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeeWithMaxSalaryBy(List<Employee> employeeList) {
        HashMap<String, Double> empSalaries =  new HashMap<>();
        employeeList.forEach(f->empSalaries.put(f.getId(), f.getSalaries().stream().mapToDouble(Salary::getTotal).sum()));
        return getMaxList(employeeList, empSalaries);
    }

    public List<Employee> getEmployeeWithMaxSalaryBy(List<Employee> employeeList, Integer year) {
        HashMap<String, Double> empSalaries =  new HashMap<>();
        employeeList.forEach(f->empSalaries.put(f.getId(), f.getSalaries().stream().filter(y->y.getYear().equals(year)).mapToDouble(Salary::getTotal).sum()));
        return getMaxList(employeeList, empSalaries);
    }

    public List<Employee> getEmployeeWithMaxSalaryBy(List<Employee> employeeList, Integer year, String month) {
        HashMap<String, Double> empSalaries =  new HashMap<>();
        try {
            Month validate = Month.valueOf(month);
            employeeList.forEach(f->empSalaries.put(f.getId(),
                    f.getSalaries().stream()
                            .filter(s->s.getYear().equals(year) && s.getMonth().equals(month))
                            .mapToDouble(Salary::getTotal).sum()));
        }
        catch (Exception e) {
//           throw new IllegalArgumentException();
             ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return  getMaxList(employeeList, empSalaries);
    }

    private List<Employee> getMaxList(List<Employee> employeeList, HashMap<String, Double> employeeMap) {
        Double maxValue = Collections.max(employeeMap.values());
        if(maxValue == 0)
            return null;
        else {
            for (Map.Entry<String, Double> e : employeeMap.entrySet()) {
                if (e.getValue() != maxValue) {
                    employeeList.remove(employeeList.stream().filter(f -> f.getId() == e.getKey()).findFirst().get());
                }
            }
        }
        return employeeList;
    }
}
