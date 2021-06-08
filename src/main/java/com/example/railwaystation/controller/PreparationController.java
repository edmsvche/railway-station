package com.example.railwaystation.controller;

import com.example.railwaystation.model.Preparation;
import com.example.railwaystation.service.PreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PreparationController {

    private final PreparationService preparationService;

    @Autowired
    public PreparationController(PreparationService preparationService) {
        this.preparationService = preparationService;
    }

    @PostMapping("/preparation")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Preparation preparation) {
        preparationService.create(preparation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/preparation")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Preparation>> read() {
        final List<Preparation> preparations = preparationService.readAll();

        return preparations != null && !preparations.isEmpty()
                ? new ResponseEntity<>(preparations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/preparation/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Preparation> read(@PathVariable(name = "id") long id) {
        final Preparation preparation = preparationService.read(id);

        return preparation != null
                ? new ResponseEntity<>(preparation, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/preparation/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Preparation preparation) {
        final boolean updated = preparationService.update(preparation, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/preparation/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = preparationService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
