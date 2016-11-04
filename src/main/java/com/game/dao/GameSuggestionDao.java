package com.game.dao;

import com.game.dto.GameInfo;

public interface GameSuggestionDao 
{
	public boolean isExist(String gname);
	
	public GameInfo getGameByName(String gameName);
}
