package com.game.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.game.dto.GameInfo;
import com.game.model.PlayStoreUrlFetching;

@RestController
@EnableWebMvc
public class DataController
{
	PlayStoreUrlFetching gameUrl=new PlayStoreUrlFetching();
	GameInfo gameInfo=new GameInfo();
	
		
		
		
		
	
	
	

}