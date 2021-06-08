package com.example.railwaystation.service;

import com.example.railwaystation.model.Passenger;

import java.util.List;

public interface PassengerService {

    void create(Passenger passenger);

    List<Passenger> readAll();

    Passenger read(long id);

    boolean update(Passenger passenger, long id);

    boolean delete(long id);
}
