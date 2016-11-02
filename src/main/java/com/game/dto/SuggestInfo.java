package com.game.dto;

public class SuggestInfo {
	private String gameName;
	private String packageName;
	private String imageUrl;
	private String gameUrl;
	private String gameRating;
	private float gameCost;
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
	public float getGameCost() {
		return gameCost;
	}
	public void setGameCost(float gameCost) {
		this.gameCost = gameCost;
	}
	public int getAffinityLevel() {
		return affinityLevel;
	}
	public void setAffinityLevel(int affinityLevel) {
		this.affinityLevel = affinityLevel;
	}

}
