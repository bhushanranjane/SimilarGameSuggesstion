package com.model.main;

import com.game.model.PlayStoreDataFetching;
import com.game.model.PlayStoreGameSuggesstion;
import com.game.model.PlayStoreUrlFetching;

public class DataMain {
	
	public static void main(String args[]){

		PlayStoreUrlFetching pUrl=new PlayStoreUrlFetching();
		PlayStoreDataFetching pdata=new PlayStoreDataFetching();
		PlayStoreGameSuggesstion pSuggest=new PlayStoreGameSuggesstion();
		
			//System.out.println("Enter the game name");
		String gname="Temple Run";
			String url=pUrl.findUrl(gname);
			//System.out.println("url is:-"+url);
		pdata.getPlaystoreData(url);
		pSuggest.getGameSuggesstion(url);
			
			
		}
		
	}


