package com.example.FinalTestTDDDay3.EmployeeService;


import com.example.FinalTestTDDDay3.Employee.Employee;
import com.example.FinalTestTDDDay3.EmployeeRepository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployeesThatAreEarningMoreThan(Double amount){
        return employeeRepo.findAll().stream().filter(employee -> employee.getSalary()>amount)
                .collect(Collectors.toList());
    }
    public List<Employee> getAllEmployeesExceedingAge(int age){
        return employeeRepo.findAll().stream().filter(employee -> employee.getAge()>age)
                .collect(Collectors.toList());
    }
    public List<Employee> getAllEmployeesWithMatchingPosition(String position){
        return employeeRepo.findAll().stream().filter(employee -> employee.getPosition()==position)
                .collect(Collectors.toList());
    }

    public Optional<Employee> getEmployeeWithHighestSalary(){
        return employeeRepo.findAll().stream()
                .max(Comparator.comparing(Employee::getSalary));
}
}
