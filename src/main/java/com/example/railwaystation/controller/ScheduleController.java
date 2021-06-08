package com.example.railwaystation.controller;

import com.example.railwaystation.model.Schedule;
import com.example.railwaystation.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/schedule")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Schedule schedule) {
        scheduleService.create(schedule);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/schedule")
    public ResponseEntity<List<Schedule>> read() {
        final List<Schedule> schedules = scheduleService.readAll();

        return schedules != null && !schedules.isEmpty()
                ? new ResponseEntity<>(schedules, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/schedule/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Schedule> read(@PathVariable(name = "id") long id) {
        final Schedule schedule = scheduleService.read(id);

        return schedule != null
                ? new ResponseEntity<>(schedule, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/schedule/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Schedule schedule) {
        final boolean updated = scheduleService.update(schedule, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/schedule/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = scheduleService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
