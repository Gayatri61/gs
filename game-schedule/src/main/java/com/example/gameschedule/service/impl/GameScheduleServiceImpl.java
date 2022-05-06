package com.example.gameschedule.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gameschedule.dto.GameScheduleDTO;
import com.example.gameschedule.dto.SoccerTeamDetails;
import com.example.gameschedule.dto.TeamDetails;
import com.example.gameschedule.service.GameScheduleService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GameScheduleServiceImpl implements GameScheduleService{
	
	public static final String DATE_FORMAT="dd/MM/yyyy";
	
	public static final String FILE_NAME="src/main/resources/soccer_teams.json";
	
	public static final int NEXT_MATCH_DAYS_DIFFERENCE=7;
	
	public static final int DAYS_BREAK =21;
	
	public static final String MATCH_START_DATE="05/03/2022";
	
	
	@Override
	public List<GameScheduleDTO> getGameSchedule() throws StreamReadException, DatabindException, IOException, ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		Date date = format.parse(MATCH_START_DATE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);		//  match start date

		ObjectMapper mapper = new ObjectMapper();
		SoccerTeamDetails soccerTeamDetails = mapper.readValue(new File(FILE_NAME), SoccerTeamDetails.class);	// read and covert file data to dto
		List<TeamDetails> allTeams=soccerTeamDetails.getTeams();
		
		List<GameScheduleDTO>  gameScheduleDTOs=new ArrayList<>();
		GameScheduleDTO gameScheduleDTO=new GameScheduleDTO();
		for(TeamDetails teamDetails: allTeams) {					// matches before break
			if(allTeams.indexOf(teamDetails)%2==0) {
				gameScheduleDTO=new GameScheduleDTO();
				gameScheduleDTO.setMatchDate(format.format(calendar.getTime()));
				gameScheduleDTO.setTeamOne(teamDetails.getName());
				calendar.add(Calendar.DAY_OF_YEAR , NEXT_MATCH_DAYS_DIFFERENCE);
			}else {
				gameScheduleDTO.setTeamTwo(teamDetails.getName());
				gameScheduleDTOs.add(gameScheduleDTO);
			}

		}
		List<GameScheduleDTO>  allGameScheduleDTO=new ArrayList<>();
		allGameScheduleDTO.addAll(gameScheduleDTOs);
		calendar.add(Calendar.DAY_OF_YEAR , DAYS_BREAK);			// set number of days break 
		
		for(GameScheduleDTO oldTeamMatches :gameScheduleDTOs) {
			gameScheduleDTO=new GameScheduleDTO();						
			gameScheduleDTO.setTeamOne(oldTeamMatches.getTeamTwo());		// swap team 
			gameScheduleDTO.setTeamTwo(oldTeamMatches.getTeamOne());
			gameScheduleDTO.setMatchDate(format.format(calendar.getTime()));
			allGameScheduleDTO.add(gameScheduleDTO);							// matches after break
			calendar.add(Calendar.DAY_OF_YEAR , NEXT_MATCH_DAYS_DIFFERENCE);
		}
		return allGameScheduleDTO;
	}

	
}
