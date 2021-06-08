package com.example.railwaystation.service;

import com.example.railwaystation.model.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee);

    List<Employee> readAll();

    Employee read(long id);

    boolean update(Employee employee, long id);

    boolean delete(long id);
}
