package com.examlpe.tickettracker.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.examlpe.tickettracker.Entity.Ticket;
import com.examlpe.tickettracker.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@GetMapping("/list")
	public ModelAndView listTickets() {
		List<Ticket> ticket = ticketService.findAll();
		ModelAndView modelView = new ModelAndView();
		
		modelView.setViewName("tickets/list-tickets");
		modelView.addObject("tickets",ticket);
		return modelView;
	}
	
	@GetMapping("/addTicket")
	public ModelAndView formForAddTicket(ModelAndView modelView) {
		Ticket ticket = new Ticket();
		modelView.setViewName("tickets/ticket-form");
		modelView.addObject("ticket",ticket);
		return modelView;
	}
	
	@PostMapping("/updateTicket")
	public String formForAddTicket(@RequestParam("ticketId") int id, Model model) {
		
		try {
			Ticket ticket = ticketService.findById(id);
			model.addAttribute("ticket", ticket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("tiket not found!!");
			e.printStackTrace();
		}
		
		return "tickets/ticket-form";
		
	}
	
	@PostMapping("/saveTicket")
	public ModelAndView saveTicket(@ModelAttribute("ticket") Ticket ticket,ModelAndView modelView) {
		System.out.print(ticket);
		ticketService.save(ticket);
		modelView.setViewName("tickets/list-tickets");
		modelView.addObject("tickets",ticket);
		return modelView;
	}
	
	@PostMapping("/deleteTicket")
	public String deleteTicket(@RequestParam("ticketId") int id) {
		ticketService.deleteById(id);
		return "redirect:/tickets/list";
	}
	
	
}
