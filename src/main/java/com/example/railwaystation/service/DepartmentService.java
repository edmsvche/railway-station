package com.example.railwaystation.service;

import com.example.railwaystation.model.Department;

import java.util.List;

public interface DepartmentService {

    void create(Department department);

    List<Department> readAll();

    Department read(long id);

    boolean update(Department department, long id);

    boolean delete(long id);
}
