package com.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.game.dao.GameSuggestionDaoImpl;
import com.game.dto.GameInfo;
import com.game.dto.SuggestInfo;
import com.game.model.PlayStoreDataFetching;
import com.game.model.PlayStoreGameSuggesstion;
import com.game.model.PlayStoreUrlFetching;

@Controller
public class DataController {
	PlayStoreUrlFetching gameUrl = new PlayStoreUrlFetching();
	PlayStoreDataFetching gameData = new PlayStoreDataFetching();
	PlayStoreGameSuggesstion suggestGame=new PlayStoreGameSuggesstion();
	GameInfo gameInfo = new GameInfo();
	SuggestInfo suggestion = new SuggestInfo();
	/* ArrayList<String> gamelist=new ArrayList<String>(); */

	@Autowired
	GameSuggestionDaoImpl gameDao;

	@RequestMapping(value = "homepage", method = RequestMethod.POST)
	public ModelAndView gameDetails(String gameName) {
		System.out.println("Search Here" + gameName);

		if (gameDao.isExist(gameName)) {
			System.out.println("Game exist");

			List<GameInfo> game = gameDao.gameDetails(gameName);
			return new ModelAndView("gameDetails", "game", game);

		} else {
			String url = gameUrl.findUrl(gameName);
			gameInfo = gameData.getPlaystoreData(url);
			gameDao.saveGame(gameInfo);
			List<GameInfo> game = gameDao.getGameByName(gameName);
			for (int i = 0; i < game.size(); i++) {
				System.out.println("game list:-" + game.get(i).getGameName());
			}
			return new ModelAndView("gameDetails", "game", game);
			// gameDao.isExist(gameName);

		}
	}
	
	@RequestMapping(value="similarGames",method=RequestMethod.POST)
	@ModelAttribute("validate")
	public ModelAndView suggestGame(String gameName){
		System.out.println("*****game suggesstion*****");
		String url=gameUrl.findUrl(gameName);
		suggestion=suggestGame.getGameSuggesstion(url);
		gameDao.saveSuggestion(suggestion);
		List<SuggestInfo> suggestion=gameDao.gameSuggest(gameName);
		return new ModelAndView("similarGames","suggestion",suggestion);
		
	}
}
		
		
		