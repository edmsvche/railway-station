package com.example.railwaystation.service.impl;

import com.example.railwaystation.model.Ticket;
import com.example.railwaystation.repository.TicketRepository;
import com.example.railwaystation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void create(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> readAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket read(long id) {
        if(ticketRepository.existsById(id))
            return ticketRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean update(Ticket ticketOrig, long id) {
        if(ticketRepository.existsById(id)){
            Optional<Ticket> found = ticketRepository.findById(id);
            if(found.isPresent()){
                Ticket ticket = found.get();
                ticket.setId(id);
                if(ticketOrig.getPrice() == null){
                    ticket.setPrice(ticketOrig.getPrice());
                }
                if(ticketOrig.getPurchaseMethod() == null){
                    ticket.setPurchaseMethod(ticketOrig.getPurchaseMethod());
                }
                if(ticketOrig.getTicketStatus() == null){
                    ticket.setTicketStatus(ticketOrig.getTicketStatus());
                }
                ticketRepository.save(ticket);
                return true;
            }
        }
        return false;
    }

    /*@Override
    public Ticket readBySchedule(long id) {
        if ()
        return null;
    }*/

    @Override
    public boolean delete(long id) {
        if(ticketRepository.existsById(id)){
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
