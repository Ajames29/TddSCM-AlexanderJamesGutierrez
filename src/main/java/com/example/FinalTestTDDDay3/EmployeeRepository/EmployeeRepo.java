package com.example.FinalTestTDDDay3.EmployeeRepository;

import com.example.FinalTestTDDDay3.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository <Employee,Long> {


}
