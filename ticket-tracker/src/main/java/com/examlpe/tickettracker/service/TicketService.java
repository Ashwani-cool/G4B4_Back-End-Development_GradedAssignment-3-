package com.examlpe.tickettracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examlpe.tickettracker.Entity.Ticket;
import com.examlpe.tickettracker.dao.TicketRepository;

@Service
public class TicketService {

	private TicketRepository ticketRepository;
	
	@Autowired
	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	public List<Ticket> findAll(){
		List<Ticket> ticketList = ticketRepository.findAll();
		return ticketList;
		
	}
	
	public Ticket findById(int id) throws Exception {
		Optional<Ticket> findResult = ticketRepository.findById(id);
		Ticket ticket = null;
		
		if(findResult.isPresent()) {
			ticket = findResult.get(); 
		}else {
			throw new Exception("Ticket Not found!!");
		}
		return ticket;
	}
	
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	public void deleteById(int id) {
		ticketRepository.deleteById(id);
	}
	
}
