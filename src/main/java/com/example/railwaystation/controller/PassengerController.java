package com.example.railwaystation.controller;

import com.example.railwaystation.model.Passenger;
import com.example.railwaystation.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping("/passenger")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Passenger passenger) {
        passengerService.create(passenger);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/passenger")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Passenger>> read() {
        final List<Passenger> passengers = passengerService.readAll();

        return passengers != null && !passengers.isEmpty()
                ? new ResponseEntity<>(passengers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/passenger/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Passenger> read(@PathVariable(name = "id") long id) {
        final Passenger passenger = passengerService.read(id);

        return passenger != null
                ? new ResponseEntity<>(passenger, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/passenger/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Passenger passenger) {
        final boolean updated = passengerService.update(passenger, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/passenger/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = passengerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
