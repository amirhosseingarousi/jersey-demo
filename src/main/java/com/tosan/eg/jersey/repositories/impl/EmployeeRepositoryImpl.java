package com.tosan.eg.jersey.repositories.impl;

import com.tosan.eg.jersey.models.Employee;
import com.tosan.eg.jersey.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoryImpl() {
        Employee emp1 = new Employee(1, "Bryan", "Hansen", "Java developer");
        Employee emp2 = new Employee(2, "Amir Hossein", "Garousi", "Fullstack developer");

        employees.add(emp1);
        employees.add(emp2);
    }
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        Employee emp = employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        return emp;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(employees.size() + 1);
        employees.add(employee);
        return employee;
    }

    @Override
    public void deleteAll() {
        employees.clear();
    }
}
