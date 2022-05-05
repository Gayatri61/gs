package com.example.gamescheduler.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gamescheduler.dto.GameScheduleDTO;
import com.example.gamescheduler.service.GameScheduleService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;



@RestController
@RequestMapping("/game/schedule")
public class GameScheduleController {

	@Autowired
	private GameScheduleService gameScheduleService;
	
	@GetMapping
	public List<GameScheduleDTO> getGameSchedule() throws StreamReadException, DatabindException, IOException, ParseException {
		return gameScheduleService.getGameSchedule();
	}	
}
