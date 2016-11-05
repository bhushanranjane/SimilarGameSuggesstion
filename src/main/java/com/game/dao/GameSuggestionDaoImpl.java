package com.game.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		Query query=session.createQuery("from GameInfo where gameName= :gameName");
		query.setParameter("gameName", gname);
		GameInfo gameInfo2=(GameInfo) query.uniqueResult();
		if(gameInfo2!=null){
			return true;
		}
		else {
			return false;
		}
	}
	
	//
	public List<GameInfo> getGameByName(String gameName){
		//Session Started
		GameInfo gameInfo=new GameInfo();
		
		session = sessionFactory.openSession();
	
			Query query=session.createQuery("from GameInfo where gameName= :gameName");
			query.setParameter("gameName", gameName);
			//GameInfo gameInfo1=(GameInfo) query.uniqueResult();
			List<GameInfo> list=query.list();
			
			if(list!=null){
				
			return list;
		}
		return null;
		
		}
	
	public GameInfo gameDetails(String gameName){
		session = sessionFactory.openSession();
		
		Query query=session.createQuery("from GameInfo where gameName=?");
		query.setString(0, gameName);	
		GameInfo gameInfo=(GameInfo) query.uniqueResult();
		return gameInfo;
		
	}
	
	
	public void saveGame(GameInfo gameInfo){
		session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();	
			session.save(gameInfo);
			tr.commit();
			session.close();
			
		}
		

}
