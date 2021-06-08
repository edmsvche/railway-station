package com.example.railwaystation.service;

import com.example.railwaystation.model.Preparation;

import java.util.List;

public interface PreparationService {

    void create(Preparation preparation);

    List<Preparation> readAll();

    Preparation read(long id);

    boolean update(Preparation preparation, long id);

    boolean delete(long id);
}
