package com.example.railwaystation.service;

import com.example.railwaystation.model.Route;

import java.util.List;

public interface RouteService {

    void create(Route route);

    List<Route> readAll();

    Route read(long id);

    boolean update(Route route, long id);

    boolean delete(long id);
}
