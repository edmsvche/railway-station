package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Examination;
import com.example.railwaystation.repository.ExaminationRepository;
import com.example.railwaystation.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    private final ExaminationRepository examinationRepository;

    @Autowired
    public ExaminationServiceImpl(ExaminationRepository examinationRepository) {
        this.examinationRepository = examinationRepository;
    }

    @Override
    public void create(Examination examination) {
        examinationRepository.save(examination);
    }

    @Override
    public List<Examination> readAll() {
        return examinationRepository.findAll();
    }

    @Override
    public Examination read(long id) {
        if(examinationRepository.existsById(id))
            return examinationRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Examination examinationOrig, long id) {
        if(examinationRepository.existsById(id)){
            Optional<Examination> found = examinationRepository.findById(id);
            if(found.isPresent()){
                Examination examination =found.get();
                examination.setId(id);
                if(examinationOrig.getEstimation() == null){
                    examination.setEstimation(examinationOrig.getEstimation());
                }
                if(examinationOrig.getDate() == null){
                    examination.setDate(examinationOrig.getDate());
                }
                examinationRepository.save(examination);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(examinationRepository.existsById(id)){
            examinationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
