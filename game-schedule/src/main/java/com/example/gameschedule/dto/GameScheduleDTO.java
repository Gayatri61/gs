package com.example.gameschedule.dto;

import java.io.Serializable;

public class GameScheduleDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String matchDate;
	
	private String teamOne;
	
	private String teamTwo;
	

	public GameScheduleDTO(String matchDate, String teamOne, String teamTwo) {
		super();
		this.matchDate = matchDate;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
	}


	public GameScheduleDTO() {
		super();
	}


	public String getMatchDate() {
		return matchDate;
	}


	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getTeamOne() {
		return teamOne;
	}


	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}


	public String getTeamTwo() {
		return teamTwo;
	}


	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}


	@Override
	public String toString() {
		return "GameScheduleDTO [matchDate=" + matchDate + ", teamOne=" + teamOne + ", teamTwo=" + teamTwo + "]";
	}
	
	
	
}
