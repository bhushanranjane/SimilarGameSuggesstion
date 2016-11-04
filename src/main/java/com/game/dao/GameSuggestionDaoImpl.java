package com.game.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.game.dto.GameInfo;

@Repository
public class GameSuggestionDaoImpl implements GameSuggestionDao {
	/*PlayStoreUrlFetching pUrl=new PlayStoreUrlFetching();
	PlayStoreDataFetching pData=new PlayStoreDataFetching();*/
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	//Check wheather the game name exist or not
	public boolean isExist(String gname){
		session=sessionFactory.openSession();
		Query query=session.createQuery("from GameInfo where gameName=?");
		GameInfo gameInfo2=(GameInfo) query.uniqueResult();
		if(gameInfo2!=null){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public GameInfo getGameByName(String gameName){
		//Session Started
		GameInfo gameInfo=new GameInfo();
		
		session = sessionFactory.openSession();
	
			Query query=session.createQuery("from GameInfo where gameName=?");
			query.setString(0, gameName);	
			GameInfo gameInfo1=(GameInfo) query.uniqueResult();
			/*System.out.println("gugbyh"+gameInfo1.getGameName());*/
			if(gameInfo1 !=null){
				
			return gameInfo;
		}
		return gameInfo1;
		
		}

	public void saveGame(GameInfo gameInfo){
		if(gameInfo.getGameName().equals(null)){
			session=sessionFactory.openSession();
			session.save(gameInfo);
		}
		else{
			session=sessionFactory.openSession();
			session.update(gameInfo);
		}
	}
	

}
