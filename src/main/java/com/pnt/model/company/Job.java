package com.pnt.model.company;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jid;
	private String language;
	private int quantity;
	private String request;
	private String time;
	private String description;
	private String note;

	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;

	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Job(String language, int quantity, String request, String time, String description, String note,
			Company company) {
		super();
		this.language = language;
		this.quantity = quantity;
		this.request = request;
		this.time = time;
		this.description = description;
		this.note = note;
		this.company = company;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getJid() {
		return jid;
	}

	public void setJid(Long jid) {
		this.jid = jid;
	}
}
