package com.game.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.dto.GameInfo;
import com.game.dto.SuggestInfo;

@Repository
public class GameSuggestionDaoImpl implements GameSuggestionDao {
	/*
	 * PlayStoreUrlFetching pUrl=new PlayStoreUrlFetching();
	 * PlayStoreDataFetching pData=new PlayStoreDataFetching();
	 */
	@Autowired
	SessionFactory sessionFactory;
	Session session;

	// Check wheather the game name exist or not
	public boolean isExist(String gname) {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from GameInfo where gameName= :gameName");
		query.setParameter("gameName", gname);
		GameInfo gameInfo2 = (GameInfo) query.uniqueResult();
		if (gameInfo2 != null) {
			return true;
		} else {
			return false;
		}
	}

	// get the game details by the game name
	public List<GameInfo> getGameByName(String gameName) {
		// Session Started
		GameInfo gameInfo = new GameInfo();

		session = sessionFactory.openSession();

		Query query = session.createQuery("from GameInfo where gameName= :gameName");
		query.setParameter("gameName", gameName);
		// GameInfo gameInfo1=(GameInfo) query.uniqueResult();
		List<GameInfo> list = query.list();

		if (list != null) {

			return list;
		}
		return null;

	}

	public List<GameInfo> gameDetails(String gameName) {
		session = sessionFactory.openSession();

		Query query = session.createQuery("from GameInfo where gameName=?");
		query.setString(0, gameName);
		List<GameInfo> gameInfo = query.list();
		return gameInfo;

	}

	// save the game details fetched from the playstore
	public void saveGame(GameInfo gameInfo) {
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(gameInfo);
		tr.commit();
		session.close();

	}

	public List<SuggestInfo> gameSuggest(String gameName) {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from SuggestInfo ");
		query.setString(0, gameName);
		List<SuggestInfo> suggestList = query.list();

		if (suggestList != null) {
			return suggestList;
		}
		return null;

	}
	
	//save the suggestion of the game
	public void saveSuggestion(SuggestInfo suggesstion){
		session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(suggesstion);
		tr.commit();
		session.close();
	}

}
