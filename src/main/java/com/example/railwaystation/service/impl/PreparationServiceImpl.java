package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Preparation;
import com.example.railwaystation.repository.PreparationRepository;
import com.example.railwaystation.service.PreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreparationServiceImpl implements PreparationService {

    private final PreparationRepository preparationRepository;

    @Autowired
    public PreparationServiceImpl(PreparationRepository preparationRepository) {
        this.preparationRepository = preparationRepository;
    }

    @Override
    public void create(Preparation preparation) {
        preparationRepository.save(preparation);
    }

    @Override
    public List<Preparation> readAll() {
        return preparationRepository.findAll();
    }

    @Override
    public Preparation read(long id) {
        if(preparationRepository.existsById(id))
            return preparationRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Preparation preparationOrig, long id) {
        if(preparationRepository.existsById(id)){
            Optional<Preparation> found = preparationRepository.findById(id);
            if(found.isPresent()){
                Preparation preparation = found.get();
                preparation.setId(id);
                if(preparationOrig.getTechnical() == null){
                    preparation.setTechnical(preparationOrig.getTechnical());
                }
                if(preparationOrig.getService() == null){
                    preparation.setService(preparationOrig.getService());
                }
                preparationRepository.save(preparation);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(preparationRepository.existsById(id)){
            preparationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
