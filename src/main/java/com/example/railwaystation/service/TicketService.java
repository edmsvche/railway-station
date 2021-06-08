package com.example.railwaystation.service;

import com.example.railwaystation.model.Ticket;

import java.util.List;

public interface TicketService {

    void create(Ticket ticket);

    List<Ticket> readAll();

    Ticket read(long id);

    boolean update(Ticket ticket, long id);

    //Ticket findBySchedule(long id);

    boolean delete(long id);
}
