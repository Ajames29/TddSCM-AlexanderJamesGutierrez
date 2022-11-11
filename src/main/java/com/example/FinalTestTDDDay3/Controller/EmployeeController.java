package com.example.FinalTestTDDDay3.Controller;

import com.example.FinalTestTDDDay3.Employee.Employee;
import com.example.FinalTestTDDDay3.EmployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{amount}")
    public ResponseEntity<List<Employee>> getAllEmployeesThatAreEarningMoreThan(@PathVariable Double amount) {
        List<Employee> employees = employeeService.getAllEmployeesThatAreEarningMoreThan(amount);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Employee>> getAllEmployeesExceedingAge(@PathVariable int age) {
        List<Employee> employees = employeeService.getAllEmployeesExceedingAge(age);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/{position}")
    public ResponseEntity<List<Employee>> getAllEmployeesWithMatchingPosition(@PathVariable String position) {
        List<Employee> employees = employeeService.getAllEmployeesWithMatchingPosition(position);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Optional<Employee>> getEmployeeWithHighestSalary() {
        Optional<Employee> employees = employeeService.getEmployeeWithHighestSalary();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


}
