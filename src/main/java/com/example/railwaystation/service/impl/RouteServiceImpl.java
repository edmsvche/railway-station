package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Route;
import com.example.railwaystation.repository.RouteRepository;
import com.example.railwaystation.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void create(Route route) {
        routeRepository.save(route);
    }

    @Override
    public List<Route> readAll() {
        return routeRepository.findAll();
    }

    @Override
    public Route read(long id) {
        if(routeRepository.existsById(id))
            return routeRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Route routeOrig, long id) {
        if(routeRepository.existsById(id)){
            Optional<Route> found = routeRepository.findById(id);
            if(found.isPresent()){
                Route route = found.get();
                route.setId(id);
                if(routeOrig.getRace() == null){
                    route.setRace(routeOrig.getRace());
                }
                if(routeOrig.getInitialDestination() == null){
                    route.setInitialDestination(routeOrig.getInitialDestination());
                }
                if(routeOrig.getFinalDestination() == null){
                    route.setInitialDestination(routeOrig.getInitialDestination());
                }
                if(routeOrig.getMainStations() == null){
                    route.setMainStations(routeOrig.getMainStations());
                }
                routeRepository.save(route);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(routeRepository.existsById(id)){
            routeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
