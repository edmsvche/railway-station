package com.example.railwaystation.service;

import com.example.railwaystation.model.Examination;

import java.util.List;

public interface ExaminationService {

    void create(Examination examination);

    List<Examination> readAll();

    Examination read(long id);

    boolean update(Examination examination, long id);

    boolean delete(long id);
}
