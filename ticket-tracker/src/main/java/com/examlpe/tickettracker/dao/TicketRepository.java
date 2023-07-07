package com.examlpe.tickettracker.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examlpe.tickettracker.Entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
