package com.example.railwaystation.service;

import com.example.railwaystation.model.Brigade;

import java.util.List;

public interface BrigadeService {

    void create(Brigade brigade);

    List<Brigade> readAll();

    Brigade read(long id);

    boolean update(Brigade brigade, long id);

    boolean delete(long id);
}
