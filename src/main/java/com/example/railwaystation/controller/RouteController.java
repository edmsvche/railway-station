package com.example.railwaystation.controller;

import com.example.railwaystation.model.Route;
import com.example.railwaystation.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/route")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> create(@RequestBody Route route) {
        routeService.create(route);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/route")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Route>> read() {
        final List<Route> routes = routeService.readAll();

        return routes != null && !routes.isEmpty()
                ? new ResponseEntity<>(routes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/route/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Route> read(@PathVariable(name = "id") long id) {
        final Route route = routeService.read(id);

        return route != null
                ? new ResponseEntity<>(route, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/route/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Route route) {
        final boolean updated = routeService.update(route, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/route/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = routeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
