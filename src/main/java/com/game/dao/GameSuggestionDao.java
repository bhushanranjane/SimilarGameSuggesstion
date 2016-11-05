package com.game.dao;

import java.util.List;

import com.game.dto.GameInfo;

public interface GameSuggestionDao 
{
	public boolean isExist(String gname);
	
	public List<GameInfo> getGameByName(String gameName);
}
