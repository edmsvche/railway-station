package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Passenger;
import com.example.railwaystation.repository.PassengerRepository;
import com.example.railwaystation.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public void create(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> readAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger read(long id) {
        if(passengerRepository.existsById(id))
            return passengerRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Passenger passengerOrig, long id) {
        if(passengerRepository.existsById(id)){
            Optional<Passenger> found = passengerRepository.findById(id);
            if(found.isPresent()){
                Passenger passenger = found.get();
                passenger.setId(id);
                if(passengerOrig.getFullName() == null){
                    passenger.setFullName(passengerOrig.getFullName());
                }
                if(passengerOrig.getPhone() == null){
                    passenger.setPhone(passengerOrig.getPhone());
                }
                if(passengerOrig.getLuggageCompartment() == null){
                    passenger.setLuggageCompartment(passengerOrig.getLuggageCompartment());
                }
                if(passengerOrig.getWeightGoods() == null){
                    passenger.setWeightGoods(passengerOrig.getWeightGoods());
                }
                passengerRepository.save(passenger);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(passengerRepository.existsById(id)){
            passengerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
