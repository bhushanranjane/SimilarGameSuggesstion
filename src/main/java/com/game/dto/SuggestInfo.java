package com.game.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private GameInfo game;
	
	
	
	public GameInfo getGame() {
		return game;
	}
	public void setGame(GameInfo game) {
		this.game = game;
	}
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
	public int getSequenceId() {
		return sequenceId;
	}
	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}
	public String getGameCost() {
		return gameCost;
	}
	public void setGameCost(String gameCost) {
		this.gameCost = gameCost;
	}
	

}
