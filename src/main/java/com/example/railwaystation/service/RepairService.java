package com.example.railwaystation.service;

import com.example.railwaystation.model.Repair;

import java.util.List;

public interface RepairService {

    void create(Repair repair);

    List<Repair> readAll();

    Repair read(long id);

    boolean update(Repair repair, long id);

    boolean delete(long id);
}
