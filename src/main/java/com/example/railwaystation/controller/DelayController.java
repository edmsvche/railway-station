package com.example.railwaystation.controller;

import com.example.railwaystation.model.Delay;
import com.example.railwaystation.service.DelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class DelayController {

    private final DelayService delayService;

    @Autowired
    public DelayController(DelayService delayService) {
        this.delayService = delayService;
    }

    @PostMapping("/delay")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Delay delay) {
        delayService.create(delay);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/delay")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Delay>> read() {
        final List<Delay> delays = delayService.readAll();

        return delays != null && !delays.isEmpty()
                ? new ResponseEntity<>(delays, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/delay/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Delay> read(@PathVariable(name = "id") long id) {
        final Delay delay = delayService.read(id);

        return delay != null
                ? new ResponseEntity<>(delay, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/delay/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Delay delay) {
        final boolean updated = delayService.update(delay, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/delay/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = delayService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
