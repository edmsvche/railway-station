package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Schedule;
import com.example.railwaystation.repository.ScheduleRepository;
import com.example.railwaystation.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void create(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> readAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule read(long id) {
        if(scheduleRepository.existsById(id))
            return scheduleRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Schedule scheduleOrig, long id) {
        if(scheduleRepository.existsById(id)){
            Optional<Schedule> found = scheduleRepository.findById(id);
            if(found.isPresent()){
                Schedule schedule = found.get();
                schedule.setId(id);
                if(scheduleOrig.getDepartureDay() == null){
                    schedule.setDepartureDay(scheduleOrig.getDepartureDay());
                }
                if(scheduleOrig.getArrivalDay() == null){
                    schedule.setArrivalDay(scheduleOrig.getArrivalDay());
                }
                if(scheduleOrig.getDepartureDate() == null){
                    schedule.setDepartureDate(scheduleOrig.getDepartureDate());
                }
                if(scheduleOrig.getArrivalDate() == null){
                    schedule.setArrivalDate(scheduleOrig.getArrivalDate());
                }
                scheduleRepository.save(schedule);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(scheduleRepository.existsById(id)){
            scheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
