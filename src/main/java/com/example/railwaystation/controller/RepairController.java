package com.example.railwaystation.controller;

import com.example.railwaystation.model.Repair;
import com.example.railwaystation.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RepairController {

    private final RepairService repairService;

    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @PostMapping("/repair")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Repair repair) {
        repairService.create(repair);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/repair")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Repair>> read() {
        final List<Repair> repairs = repairService.readAll();

        return repairs != null && !repairs.isEmpty()
                ? new ResponseEntity<>(repairs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/repair/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Repair> read(@PathVariable(name = "id") long id) {
        final Repair repair = repairService.read(id);

        return repair != null
                ? new ResponseEntity<>(repair, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/repair/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Repair repair) {
        final boolean updated = repairService.update(repair, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/repair/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = repairService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
