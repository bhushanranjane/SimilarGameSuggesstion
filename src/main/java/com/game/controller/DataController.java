package com.game.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	PlayStoreGameSuggesstion suggestGame = new PlayStoreGameSuggesstion();
	GameInfo gameInfo = new GameInfo();
	/*SuggestInfo suggestion = new SuggestInfo();*/
	/* ArrayList<String> gamelist=new ArrayList<String>(); */

	@Autowired
	GameSuggestionDaoImpl gameDao;

	@RequestMapping(value = "homepage", method = RequestMethod.POST)
	public ModelAndView gameDetails(String gameName) {
		System.out.println("Search Here" + gameName);
		Map<String, Object> model = new HashMap<String, Object>();
		if (gameDao.isExist(gameName)) {
			System.out.println("Game exist");

			List<GameInfo> game = gameDao.gameDetails(gameName);
			ArrayList<SuggestInfo> suggestion = (ArrayList<SuggestInfo>) gameDao.gameSuggest(gameName);
			model.put("game", game);
			model.put("suggestion", suggestion);
			return new ModelAndView("gameDetails", "model", model);

		} else {

			String url = gameUrl.findUrl(gameName);
			gameInfo = gameData.getPlaystoreData(url);
			gameDao.saveGame(gameInfo);
			List<GameInfo> game = gameDao.getGameByName(gameName);
			for (int i = 0; i < game.size(); i++) {
				System.out.println("game list:-" + game.get(i).getGameName());
			}
			ArrayList<SuggestInfo> suggestion1 = suggestGame.getGameSuggesstion(url);
			for (SuggestInfo suggestInfo : suggestion1) {
				gameDao.saveSuggestion(suggestInfo);
				List<SuggestInfo> suggestion = gameDao.gameSuggest(gameName);
				model.put("game", game);
				model.put("suggestion", suggestion);

			}
		}
		return new ModelAndView("gameDetails", "model", model);
	}

}
