package com.example.gamescheduler.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.example.gamescheduler.dto.GameScheduleDTO;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public interface GameScheduleService {

	List<GameScheduleDTO> getGameSchedule() throws StreamReadException, DatabindException, IOException, ParseException;

}
