package com.game.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.game.model.PlayStoreUrlFetching;

@RestController
@EnableWebMvc
public class DataController
{
	PlayStoreUrlFetching pUrl=new PlayStoreUrlFetching();
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public void urlFound(String gname){
		//System.out.println("Enter the game name");
		gname="subwaysurfer";
		try {
			String url=pUrl.encodeUrl(gname);
			System.out.println("url is:-"+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}