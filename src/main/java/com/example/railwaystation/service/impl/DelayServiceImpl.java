package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Delay;
import com.example.railwaystation.model.enums.Cause;
import com.example.railwaystation.repository.DelayRepository;
import com.example.railwaystation.service.DelayService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DelayServiceImpl implements DelayService {

    private final DelayRepository delayRepository;
    private Cause cause;

    public DelayServiceImpl(DelayRepository delayRepository) {
        this.delayRepository = delayRepository;
    }

    @Override
    public void create(Delay delay) {
        delayRepository.save(delay);
    }

    @Override
    public List<Delay> readAll() {
        return delayRepository.findAll();
    }

    @Override
    public Delay read(long id) {
        if (delayRepository.existsById(id))
            return delayRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Delay delayOrig, long id) {
        if (delayRepository.existsById(id)) {
            Optional<Delay> found = delayRepository.findById(id);
            if (found.isPresent()) {
                Delay delay = found.get();
                delay.setId(id);
                if (delayOrig.getCause() == null) {
                    delay.setCause(delayOrig.getCause());
                }
                if (delayOrig.getHoursSpent() == null) {
                    delay.setHoursSpent(delayOrig.getHoursSpent());
                }
                delayRepository.save(delay);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (delayRepository.existsById(id)) {
            delayRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
