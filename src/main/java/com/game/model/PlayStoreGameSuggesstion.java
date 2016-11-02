package com.game.model;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.game.dto.SuggestInfo;

public class PlayStoreGameSuggesstion {
	PlayStoreUrlFetching playStoreUrl = new PlayStoreUrlFetching();
	SuggestInfo suggesstion = new SuggestInfo();

	public SuggestInfo getGameSuggesstion(String url) {
		try {

			System.out.println("Url:"+url);
			Document doc = Jsoup.connect(url).userAgent("Chrome/50.0.2661.94").timeout(10000).get();

			// get the titles of the suggested game
			//Elements title = doc.getElementsByClass("details");
			Elements e=doc.select("div.cards.id-card-list");
			//System.out.println("e:"+e.toString());
			//Elements t=e.select("[class=id-track-impression]");
			Elements t1=e.select("[class=details]");
			String gameTitle = t1.select("[class=title]").toString();
			//String gameTitle = title.select("[class=title]").toString();
			String[] gamename = gameTitle.split("title");
			
			
			Elements img=doc.getElementsByClass("cover-inner-align");
			String imageUrl=img.select("[class=cover-image]").toString();
			String imgurl[]=imageUrl.split("data-cover-small");
			
				
			//System.out.println("image url:-"+imageUrl);
			
			
			
			ArrayList<String> games = new ArrayList<String>();
			ArrayList<String> imageinfo=new ArrayList<String>();
			
			for (int i = 0; i < gamename.length; i++) {
				if (gamename[i].contains("href"))
					continue;
				//System.out.println("split game name:"+gamenAME[i]);
				try {
					games.add(gamename[i].substring(gamename[i].indexOf(">") + 1, gamename[i].indexOf("<") - 1));
						
				} catch (StringIndexOutOfBoundsException e1) {
					System.out.println("error occured");
				}	
			}
			
			for (int j = 0; j < games.size(); j++) {
				String gameUrl=playStoreUrl.findUrl(games.get(j));
				String packName =gameUrl.substring(gameUrl.indexOf("id=") + 3);
				System.out.println("Game name :-"+games.get(j));
				System.out.println("PackageName is-"+packName);
				System.out.println("url for the game is:-"+gameUrl);
				//System.out.println("image url:-"+imgurl[j]);
				
				
				
			}

			System.out.println("Suggestion Game Title arraylist:" + games.toString());

		} catch (IOException e) {

			e.printStackTrace();
		}

		return suggesstion;
	}

}
