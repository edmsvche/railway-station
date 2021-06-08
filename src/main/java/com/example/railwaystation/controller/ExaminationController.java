package com.example.railwaystation.controller;

import com.example.railwaystation.model.Examination;
import com.example.railwaystation.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ExaminationController {

    private final ExaminationService examinationService;

    @Autowired
    public ExaminationController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @PostMapping("/examination")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Examination examination) {
        examinationService.create(examination);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/examination")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Examination>> read() {
        final List<Examination> examinations = examinationService.readAll();

        return examinations != null && !examinations.isEmpty()
                ? new ResponseEntity<>(examinations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/examination/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Examination> read(@PathVariable(name = "id") long id) {
        final Examination examination = examinationService.read(id);

        return examination != null
                ? new ResponseEntity<>(examination, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/examination/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Examination examination) {
        final boolean updated = examinationService.update(examination, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/examination/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = examinationService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
