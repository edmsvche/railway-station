package com.example.railwaystation.service;

import com.example.railwaystation.model.Delay;

import java.util.List;

public interface DelayService {

    void create(Delay delay);

    List<Delay> readAll();

    Delay read(long id);

    boolean update(Delay delay, long id);

    boolean delete(long id);
}
