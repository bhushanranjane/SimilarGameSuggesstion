package com.game.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SuggestInfo {
	
	@Id
	@GeneratedValue
	private int sequenceId;
	
	@Column
	private String gameName;
	
	@Column
	private String packageName;
	
	@Column
	private String imageUrl;
	
	@Column
	private String gameUrl;
	
	@Column
	private String gameRating;
	
	@Column
	private String gameCost;
	
	@Column
	private int affinityLevel;
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getGameUrl() {
		return gameUrl;
	}
	public void setGameUrl(String gameUrl) {
		this.gameUrl = gameUrl;
	}
	public String getGameRating() {
		return gameRating;
	}
	public void setGameRating(String gameRating) {
		this.gameRating = gameRating;
	}
	public String getGameCost() {
		return gameCost;
	}
	public void setGameCost(String gameCost) {
		this.gameCost = gameCost;
	}
	public int getAffinityLevel() {
		return affinityLevel;
	}
	public void setAffinityLevel(int affinityLevel) {
		this.affinityLevel = affinityLevel;
	}

}
