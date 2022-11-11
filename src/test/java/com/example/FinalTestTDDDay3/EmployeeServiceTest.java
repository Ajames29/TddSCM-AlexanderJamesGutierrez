package com.example.FinalTestTDDDay3;

import com.example.FinalTestTDDDay3.Employee.Employee;
import com.example.FinalTestTDDDay3.EmployeeRepository.EmployeeRepo;
import com.example.FinalTestTDDDay3.EmployeeService.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepo employeeRepo;
    @InjectMocks
    private EmployeeService employeeService;


    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesThatAreEarningMoreThan is executed with input 90000 " +
            "THEN result should return  JohnMicheal and Alexa ")
    public void testEmployeesEarningsMoreThanAmaount(){
        //Arrange
        Employee JohnMicheal = new Employee(1L, "JohnMicheal", 23, 150000d, "Senior Software Engineer");
        Employee JohnRaven = new Employee(2L, "JohnRaven", 22, 20000d, "Manager Coffee");
        Employee Alexa = new Employee(3L, "Alexa", 30, 100000d, "Senior Software Engineer");
        List<Employee> employees = List.of(JohnMicheal, JohnRaven, Alexa);
        Mockito.when(employeeRepo.findAll()).thenReturn(employees);

        //Act
        List<Employee> result = employeeService.getAllEmployeesThatAreEarningMoreThan(90000d);
        //Assert
        assertThat(result).contains(JohnMicheal,Alexa);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesExceedingAge is executed with input 22 above" +
            "THEN result should return JohnMichel and Alexa ")

    public void testEmployeesExceedingAge() {

        //Arrange
        Employee JohnMicheal = new Employee(1L, "JohnMicheal", 23, 150000d, "Senior Software Engineer");
        Employee JohnRaven = new Employee(2L, "JohnRaven", 22, 20000d, "Manager Coffee");
        Employee Alexa = new Employee(3L, "Alexa", 30, 100000d, "Senior Software Engineer");
        List<Employee> employees = List.of(JohnMicheal, JohnRaven, Alexa);
        Mockito.when(employeeRepo.findAll()).thenReturn(employees);

        //Act
        List<Employee> result = employeeService.getAllEmployeesExceedingAge(22);
        //Assert
        assertThat(result).contains(JohnMicheal,Alexa);

    }
    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesWithMatchingPosition is executed with input Senior Software Engineer" +
            "THEN result should return JohnMichel and Alexa ")

    public void testAllEmployeesWithMatchingPosition() {

        //Arrange
        Employee JohnMicheal = new Employee(1L, "JohnMicheal", 23, 150000d, "Senior Software Engineer");
        Employee JohnRaven = new Employee(2L, "JohnRaven", 22, 20000d, "Manager Coffee");
        Employee Alexa = new Employee(3L, "Alexa", 30, 100000d, "Senior Software Engineer");
        List<Employee> employees = List.of(JohnMicheal, JohnRaven, Alexa);
        Mockito.when(employeeRepo.findAll()).thenReturn(employees);

        //Act
        List<Employee> result = employeeService.getAllEmployeesWithMatchingPosition( "Senior Software Engineer");
        //Assert
        assertThat(result).contains(JohnMicheal,Alexa);

    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getEmployeeWithHighestSalary is executed with input Highestsalary" +
            "THEN result should return JohnMichel and Alexa ")

    public void testEmployeeWithHighestSalary() {

        //Arrange
        Employee JohnMicheal = new Employee(1L, "JohnMicheal", 23, 150000d, "Senior Software Engineer");
        Employee JohnRaven = new Employee(2L, "JohnRaven", 22, 20000d, "Manager Coffee");
        Employee Alexa = new Employee(3L, "Alexa", 30, 100000d, "Senior Software Engineer");
        List<Employee> employees = List.of(JohnMicheal, JohnRaven, Alexa);
        Mockito.when(employeeRepo.findAll()).thenReturn(employees);

        //Act
        Optional<Employee> result = employeeService.getEmployeeWithHighestSalary();
        //Assert
        assertThat(result).contains(JohnMicheal);

    }

}
