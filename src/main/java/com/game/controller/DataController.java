package com.game.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.game.dao.GameSuggestionDaoImpl;
import com.game.dto.GameInfo;
import com.game.dto.SuggestInfo;
import com.game.model.PlayStoreDataFetching;
import com.game.model.PlayStoreUrlFetching;

@Controller
public class DataController
{
	PlayStoreUrlFetching gameUrl=new PlayStoreUrlFetching();
	PlayStoreDataFetching gameData=new PlayStoreDataFetching();
	GameInfo gameInfo=new GameInfo();
	SuggestInfo suggestion=new SuggestInfo();
	ArrayList<String> gamelist=new ArrayList<String>();
	
	@Autowired
	GameSuggestionDaoImpl gameDao;
	
	@RequestMapping(value="homepage",method=RequestMethod.POST)
	public ModelAndView gameDetails(String gameName){
		System.out.println("Search Here");
		//gameDao.getGameByName(gameName);
		String url=gameUrl.findUrl(gameName);
		gamelist=gameData.getPlaystoreData(url);
		System.out.println("gamlist:-"+gamelist.toString());
		return new ModelAndView("gameDetails","gameInfo",gamelist); 
	}
		
		
		
		
	
	
	

}