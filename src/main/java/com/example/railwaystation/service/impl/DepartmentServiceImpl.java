package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Department;
import com.example.railwaystation.repository.DepartmentRepository;
import com.example.railwaystation.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> readAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department read(long id) {
        if (departmentRepository.existsById(id))
            return departmentRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Department departmentOrig, long id) {
        if (departmentRepository.existsById(id)) {
            Optional<Department> found = departmentRepository.findById(id);
            if (found.isPresent()) {
                Department department = found.get();
                department.setId(id);
                if (departmentOrig.getRegion() == null) {
                    department.setRegion(departmentOrig.getRegion());
                }
                departmentRepository.save(department);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
