package com.example.railwaystation.service;

import com.example.railwaystation.model.Schedule;

import java.util.List;

public interface ScheduleService {

    void create(Schedule schedule);

    List<Schedule> readAll();

    Schedule read(long id);

    boolean update(Schedule schedule, long id);

    boolean delete(long id);
}
