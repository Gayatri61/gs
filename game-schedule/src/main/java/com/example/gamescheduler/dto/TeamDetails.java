package com.example.gamescheduler.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TeamDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	

	private String founding_date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFounding_date() {
		return founding_date;
	}

	public void setFounding_date(String founding_date) {
		this.founding_date = founding_date;
	}

	
	
}
