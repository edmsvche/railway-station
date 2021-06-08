package com.example.railwaystation.controller;

import com.example.railwaystation.model.Locomotive;
import com.example.railwaystation.service.LocomotiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class LocomotiveController {

    private final LocomotiveService locomotiveService;

    @Autowired
    public LocomotiveController(LocomotiveService locomotiveService) {
        this.locomotiveService = locomotiveService;
    }

    @PostMapping("/locomotive")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Locomotive locomotive) {
        locomotiveService.create(locomotive);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/locomotive")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Locomotive>> read() {
        final List<Locomotive> locomotives = locomotiveService.readAll();

        return locomotives != null && !locomotives.isEmpty()
                ? new ResponseEntity<>(locomotives, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/locomotive/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Locomotive> read(@PathVariable(name = "id") long id) {
        final Locomotive locomotive = locomotiveService.read(id);

        return locomotive != null
                ? new ResponseEntity<>(locomotive, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/locomotive/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Locomotive locomotive) {
        final boolean updated = locomotiveService.update(locomotive, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/locomotive/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = locomotiveService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
