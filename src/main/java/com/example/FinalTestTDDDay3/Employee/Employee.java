package com.example.FinalTestTDDDay3.Employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Employee(){}

    public Employee(Long id, String name, int age, Double salary, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    private String name;
    private int age;
    private Double salary;
    private String position;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (!Objects.equals(id, employee.id)) return false;
        if (!Objects.equals(name, employee.name)) return false;
        if (!Objects.equals(salary, employee.salary)) return false;
        return Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
