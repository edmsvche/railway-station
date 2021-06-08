package com.example.railwaystation.controller;

import com.example.railwaystation.model.Brigade;
import com.example.railwaystation.service.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class BrigadeController {

    private final BrigadeService brigadeService;

    @Autowired
    public BrigadeController(BrigadeService brigadeService) {
        this.brigadeService = brigadeService;
    }

    @PostMapping("/brigade")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Brigade brigade) {
        brigadeService.create(brigade);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/brigade")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Brigade>> read() {
        final List<Brigade> brigades = brigadeService.readAll();

        return brigades != null && !brigades.isEmpty()
                ? new ResponseEntity<>(brigades, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/brigade/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Brigade> read(@PathVariable(name = "id") long id) {
        final Brigade brigade = brigadeService.read(id);

        return brigade != null
                ? new ResponseEntity<>(brigade, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/brigade/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Brigade brigade) {
        final boolean updated = brigadeService.update(brigade, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/brigade/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = brigadeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
