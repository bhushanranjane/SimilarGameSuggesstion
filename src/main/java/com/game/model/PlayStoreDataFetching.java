package com.game.model;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.game.dto.GameInfo;

public class PlayStoreDataFetching {

	PlayStoreUrlFetching playStoreUrl = new PlayStoreUrlFetching();
	GameInfo gameInfo = new GameInfo();

	public GameInfo getPlaystoreData(String url) {
		
		ArrayList<String> playStoreDetails = new ArrayList<String>();
		try {

			// fetching the document over HTTP
			Document doc = Jsoup.connect(url).userAgent("Chrome/50.0.2661.94").timeout(10000).get();

			// getting game title class to fetch title
			Elements t = doc.getElementsByClass("document-title");
			// Store the title into string
			String title = t.select("[class=id-app-title]").text();
			gameInfo.setGameName(title);

			// getting package name of the game
			Elements g = doc.getElementsByClass("details-wrapper apps");
			String packName = url.substring(url.indexOf("id=") + 3);
			gameInfo.setPackageName(packName);

			// getting the category of the game
			Elements category = doc.getElementsByClass("document-subtitle");
			String catInfo = category.select("[itemprop=genre]").text();
			/*System.out.println("category :-"+catInfo);*/
			gameInfo.setGameCategory(catInfo);

			// generate unique hash code for each game
			String packageId=Integer.toString(packName.hashCode()  & Integer.MAX_VALUE);
			gameInfo.setPackageId(packageId);

			// get the url of the game
			String gameUrl = url;
			gameInfo.setGameURL(gameUrl);
			
			Elements status=doc.getElementsByClass("id-track-impression");
			
			String charge=status.text();
			String cost;
			//System.out.println("cahrge"+charge);
			
			if(charge.startsWith("₹")){
			 cost=charge.substring(charge.indexOf("₹")+1,charge.indexOf("Buy")-1);
			gameInfo.setPaid(cost);
			}
			else
			{
				gameInfo.setPaid("Free");
			}
			
			if(packageId == null && title.equals("") && packName.equals("") && catInfo.equals("") && gameUrl.equals(""))
				return null;
			else{
				/*playStoreDetails.add(gameInfo.getPackageId());
				playStoreDetails.add(gameInfo.getGameName());
				playStoreDetails.add(gameInfo.getPackageName());
				playStoreDetails.add(gameInfo.getGameCategory());
				playStoreDetails.add(gameInfo.getGameURL());
				playStoreDetails.add(gameInfo.getPaid());*/
				
				
				System.out.println("package id:-"+gameInfo.getPackageId());
				System.out.println("Game Name:-"+gameInfo.getGameName());
				System.out.println("package Name:-"+gameInfo.getPackageName());
				System.out.println("game category:-"+gameInfo.getGameCategory());
				System.out.println("game url:-"+gameInfo.getGameURL());
				System.out.println("Paid/Unpaid:-"+gameInfo.getPaid());
				
				
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return gameInfo;
	}
}
