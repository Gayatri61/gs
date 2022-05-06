package com.example.gameschedule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.gameschedule.dto.GameScheduleDTO;
import com.example.gameschedule.service.impl.GameScheduleServiceImpl;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@ExtendWith(MockitoExtension.class)
class GameScheduleApplicationTests {

	@InjectMocks
	private GameScheduleServiceImpl gameScheduleServiceImpl;
	

	
	@Test
	public void testGameSchedule() throws StreamReadException, DatabindException, IOException, ParseException {
		List<GameScheduleDTO>  actualGameScheduleDTOs = gameScheduleServiceImpl.getGameSchedule();
		List<GameScheduleDTO> expectedGameScheduleDTOs = buildExpectedResponce();
		assertEquals(expectedGameScheduleDTOs.toString(), actualGameScheduleDTOs.toString());
	}



	private List<GameScheduleDTO> buildExpectedResponce() {
		List<GameScheduleDTO>  expectedGameScheduleDTOs=new ArrayList<>();
		GameScheduleDTO gameScheduleDTO1=new GameScheduleDTO("05/03/2022","Volksbank Kickers","Arminia Sparkasse");
		GameScheduleDTO gameScheduleDTO2=new GameScheduleDTO("12/03/2022","DJ FC","1. FC Marco");
		GameScheduleDTO gameScheduleDTO3=new GameScheduleDTO("19/03/2022","Borussia Helvetia","SC Graz");
		GameScheduleDTO gameScheduleDTO4=new GameScheduleDTO("16/04/2022","Arminia Sparkasse","Volksbank Kickers");
		GameScheduleDTO gameScheduleDTO5=new GameScheduleDTO("23/04/2022","1. FC Marco","DJ FC");
		GameScheduleDTO gameScheduleDTO6=new GameScheduleDTO("30/04/2022","SC Graz","Borussia Helvetia");
		expectedGameScheduleDTOs.add(gameScheduleDTO1);
		expectedGameScheduleDTOs.add(gameScheduleDTO2);
		expectedGameScheduleDTOs.add(gameScheduleDTO3);
		expectedGameScheduleDTOs.add(gameScheduleDTO4);
		expectedGameScheduleDTOs.add(gameScheduleDTO5);
		expectedGameScheduleDTOs.add(gameScheduleDTO6);
		return expectedGameScheduleDTOs;
	}

}
