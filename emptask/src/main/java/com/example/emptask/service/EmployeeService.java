package com.example.emptask.service;


import com.example.emptask.entity.Employee;
import com.example.emptask.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Employee addEmployee(Employee emp){
        return repository.save(emp);
    }

    public List<String> getNames(){
        return repository.getAllEmployeeNames();
    }

    public long totalEmployees(){
        return repository.count();
    }

    public Employee highestSalary(){
        return repository.findTopByOrderBySalaryDesc();
    }

    public List<Employee> top5(){
        return repository.findTop5ByOrderBySalaryDesc();
    }
}

