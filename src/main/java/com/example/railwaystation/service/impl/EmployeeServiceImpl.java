package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Employee;
import com.example.railwaystation.repository.EmployeeRepository;
import com.example.railwaystation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> readAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee read(long id) {
        if (employeeRepository.existsById(id))
            return employeeRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Employee employeeOrig, long id) {
        if (employeeRepository.existsById(id)) {
            Optional<Employee> found = employeeRepository.findById(id);
            if (found.isPresent()) {
                Employee employee = found.get();
                employee.setId(id);
                if (employeeOrig.getFullName() == null) {
                    employee.setFullName(employeeOrig.getFullName());
                }
                if (employeeOrig.getAge() == null) {
                    employee.setAge(employeeOrig.getAge());
                }
                if (employeeOrig.getSkills() == null) {
                    employee.setSkills(employeeOrig.getSkills());
                }
                if (employeeOrig.getSalary() == null) {
                    employee.setSalary(employeeOrig.getSalary());
                }
                if (employeeOrig.getGender() == null) {
                    employee.setGender(employeeOrig.getGender());
                }
                if (employeeOrig.getTown() == null) {
                    employee.setTown(employeeOrig.getTown());
                }
                if (employeeOrig.getChildrenNumber() == null) {
                    employee.setChildrenNumber(employeeOrig.getChildrenNumber());
                }
                employeeRepository.save(employee);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
