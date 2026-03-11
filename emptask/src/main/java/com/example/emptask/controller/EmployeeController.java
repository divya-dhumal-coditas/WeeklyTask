package com.example.emptask.controller;


import com.example.emptask.entity.Employee;
import com.example.emptask.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    @GetMapping("/names")
    public List<String> names(){
        return service.getNames();
    }

    @GetMapping("/count")
    public long count(){
        return service.totalEmployees();
    }

    @GetMapping("/highest")
    public Employee highest(){
        return service.highestSalary();
    }

    @GetMapping("/top5")
    public List<Employee> top5(){
        return service.top5();
    }
}
