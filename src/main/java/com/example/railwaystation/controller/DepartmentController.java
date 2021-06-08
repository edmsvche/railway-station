package com.example.railwaystation.controller;

import com.example.railwaystation.model.Department;
import com.example.railwaystation.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Department department) {
        departmentService.create(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/department")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Department>> read() {
        final List<Department> departments = departmentService.readAll();

        return departments != null && !departments.isEmpty()
                ? new ResponseEntity<>(departments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/department/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Department> read(@PathVariable(name = "id") long id) {
        final Department department = departmentService.read(id);

        return department != null
                ? new ResponseEntity<>(department, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/department/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Department department) {
        final boolean updated = departmentService.update(department, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/department/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = departmentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
