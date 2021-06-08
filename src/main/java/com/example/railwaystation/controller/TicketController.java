package com.example.railwaystation.controller;

import com.example.railwaystation.model.Ticket;
import com.example.railwaystation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Ticket ticket) {
        ticketService.create(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/ticket")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Ticket>> read() {
        final List<Ticket> tickets = ticketService.readAll();

        return tickets != null && !tickets.isEmpty()
                ? new ResponseEntity<>(tickets, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*@GetMapping("/ticket_by_schedule/{scheduleId}")
    public ResponseEntity<List<Ticket>> read(@PathVariable(name = "scheduleId") long scheduleId) {
        final List<Ticket> tickets = ticketService.read(scheduleId);


        return tickets != null && !tickets.isEmpty()
                ? new ResponseEntity<>(tickets, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @GetMapping("/ticket/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Ticket> read(@PathVariable(name = "id") long id) {
        final Ticket ticket = ticketService.read(id);

        return ticket != null
                ? new ResponseEntity<>(ticket, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/ticket/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Ticket ticket) {
        final boolean updated = ticketService.update(ticket, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/ticket/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = ticketService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
