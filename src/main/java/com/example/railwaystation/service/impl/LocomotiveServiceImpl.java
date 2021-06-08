package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Locomotive;
import com.example.railwaystation.repository.LocomotiveRepository;
import com.example.railwaystation.service.LocomotiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocomotiveServiceImpl implements LocomotiveService {

    private final LocomotiveRepository locomotiveRepository;

    @Autowired
    public LocomotiveServiceImpl(LocomotiveRepository locomotiveRepository) {
        this.locomotiveRepository = locomotiveRepository;
    }

    @Override
    public void create(Locomotive locomotive) {
        locomotiveRepository.save(locomotive);
    }

    @Override
    public List<Locomotive> readAll() {
        return locomotiveRepository.findAll();
    }

    @Override
    public Locomotive read(long id) {
        if(locomotiveRepository.existsById(id))
            return locomotiveRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Locomotive locomotiveOrig, long id) {
        if(locomotiveRepository.existsById(id)){
            Optional<Locomotive> found = locomotiveRepository.findById(id);
            if(found.isPresent()){
                Locomotive locomotive = found.get();
                locomotive.setId(id);
                if(locomotiveOrig.getNumberWagons() == null){
                    locomotive.setNumberWagons(locomotiveOrig.getNumberWagons());
                }
                if(locomotiveOrig.getType() == null){
                    locomotive.setType(locomotiveOrig.getType());
                }
                if(locomotiveOrig.getCondition() == null){
                    locomotive.setCondition(locomotiveOrig.getCondition());
                }
                locomotiveRepository.save(locomotive);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(locomotiveRepository.existsById(id)){
            locomotiveRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
