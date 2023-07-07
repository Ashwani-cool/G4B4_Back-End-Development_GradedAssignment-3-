package com.examlpe.tickettracker.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = " ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column( name = "content")
	private String content;
	@Column(name = "createdOn")
	private Date createdOn;
	
	public Ticket() {
		
	}
	public Ticket(int id, String title, String description, String content, Date createdOn) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.createdOn = createdOn;
	}
	public Ticket(String title, String description, String content, Date createdOn) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
		this.createdOn = createdOn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = new Date();
	}
	
}
