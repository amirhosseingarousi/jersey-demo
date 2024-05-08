package com.tosan.eg.jersey.repositories;

import com.tosan.eg.jersey.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee createEmployee(Employee employee);
    void deleteAll();
}
