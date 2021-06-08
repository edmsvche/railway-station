package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Repair;
import com.example.railwaystation.repository.RepairRepository;
import com.example.railwaystation.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;

    @Autowired
    public RepairServiceImpl(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    @Override
    public void create(Repair repair) {
        repairRepository.save(repair);
    }

    @Override
    public List<Repair> readAll() {
        return repairRepository.findAll();
    }

    @Override
    public Repair read(long id) {
        if (repairRepository.existsById(id))
            return repairRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Repair repairOrig, long id) {
        if (repairRepository.existsById(id)) {
            Optional<Repair> found = repairRepository.findById(id);
            if (found.isPresent()) {
                Repair repair = found.get();
                repair.setId(id);
                if (repairOrig.getKind() == null) {
                    repair.setKind(repairOrig.getKind());
                }
                repairRepository.save(repair);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (repairRepository.existsById(id)) {
            repairRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
