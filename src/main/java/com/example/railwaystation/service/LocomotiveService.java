package com.example.railwaystation.service;

import com.example.railwaystation.model.Locomotive;

import java.util.List;

public interface LocomotiveService {

    void create(Locomotive locomotive);

    List<Locomotive> readAll();

    Locomotive read(long id);

    boolean update(Locomotive locomotive, long id);

    boolean delete(long id);
}
