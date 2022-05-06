package com.example.gameschedule.dto;

import java.io.Serializable;
import java.util.List;

public class SoccerTeamDetails implements Serializable{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String league;
	
	private String country;
	  
	private List<TeamDetails> teams;

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<TeamDetails> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamDetails> teams) {
		this.teams = teams;
	}


	
	

}
