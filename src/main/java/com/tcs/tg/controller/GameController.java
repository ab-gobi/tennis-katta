package com.tcs.tg.controller;

import com.tcs.tg.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	@Value("${player1}")
	private String player1;
	
	@Value("${player2}")
	private String player2;
	
	@Autowired
	GameService gameService = new GameService();
	
	@RequestMapping(value="/getScore/{point1}/{point2}",method = RequestMethod.GET)
	public ResponseEntity<String> get(@PathVariable String point1,@PathVariable String point2)
	{
		String score;
		ResponseEntity<String> rs;
		try
		{
			gameService.setP1N(player1);
			gameService.setP2N(player2);
			score= gameService.getScore(Integer.parseInt(point1),Integer.parseInt(point2));
			rs = new ResponseEntity<String>(score, HttpStatus.OK);
		}
		catch(NumberFormatException e) {
			rs = new ResponseEntity<String>("Invalid input", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rs;
	}

}
