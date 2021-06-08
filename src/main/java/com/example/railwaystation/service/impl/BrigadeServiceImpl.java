package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Brigade;
import com.example.railwaystation.repository.BrigadeRepository;
import com.example.railwaystation.service.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrigadeServiceImpl implements BrigadeService {

    private final BrigadeRepository brigadeRepository;

    @Autowired
    public BrigadeServiceImpl(BrigadeRepository brigadeRepository) {
        this.brigadeRepository = brigadeRepository;
    }

    @Override
    public void create(Brigade brigade) {
        brigadeRepository.save(brigade);
    }

    @Override
    public List<Brigade> readAll() {
        return brigadeRepository.findAll();
    }

    @Override
    public Brigade read(long id) {
        if (brigadeRepository.existsById(id))
            return brigadeRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Brigade brigadeOrig, long id) {
        if (brigadeRepository.existsById(id)) {
            Optional<Brigade> found = brigadeRepository.findById(id);
            if (found.isPresent()) {
                Brigade brigade = found.get();
                brigade.setId(id);
                if (brigadeOrig.getType() == null) {
                    brigade.setType(brigadeOrig.getType());
                }
                brigadeRepository.save(brigade);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (brigadeRepository.existsById(id)) {
            brigadeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
