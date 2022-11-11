package com.example.FinalTestTDDDay3;

import com.example.FinalTestTDDDay3.Employee.Employee;
import com.example.FinalTestTDDDay3.EmployeeRepository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class EmployeeRepoTest {
    @Autowired
    EmployeeRepo employeeRepo;





    @Test
    @DisplayName("Given employees from EmployeeServiceImpl with the setup above " +
            "WHEN getAllEmployees is executed  " +
            "THEN result should return JohnMicheal,JohnRaven,Alexa  ")
    public void getAllEmployees() {
        //Arrange
        Employee JohnMicheal = new Employee(1L, "JohnMicheal", 23, 150000d, "Senior Software Engineer");
        Employee JohnRaven = new Employee(2L, "JohnRaven", 22, 20000d, "Manager Coffee");
        Employee Alexa = new Employee(3L, "Alexa", 30, 100000d, "Senior Software Engineer");
        List<Employee> employees = employeeRepo.saveAll(Arrays.asList(JohnMicheal
                , JohnRaven, Alexa));
        //Act
        Iterable<Employee> result = employeeRepo.findAll();
        //Assert
        assertThat(result).contains(JohnMicheal
                , JohnRaven, Alexa);

    }
    @Test
    @DisplayName("Given employees from EmployeeServiceImpl with the setup above " +
            "WHEN getAllEmployees is executed  " +
            "THEN result should return JohnMicheal,JohnRaven,Alexa  ")
    public void getfindAllById() {
        //Arrange
        Employee JohnMicheal = new Employee(1L, "JohnMicheal", 23, 150000d, "Senior Software Engineer");
        Employee JohnRaven = new Employee(2L, "JohnRaven", 22, 20000d, "Manager Coffee");
        Employee Alexa = new Employee(3L, "Alexa", 30, 100000d, "Senior Software Engineer");
        List<Employee> employees = employeeRepo.saveAll(Arrays.asList(JohnMicheal
                , JohnRaven, Alexa));

        //Act
        Optional<Employee> result = employeeRepo.findById(1L);
        //Assert
        assertThat(result).contains(JohnMicheal);

    }
}