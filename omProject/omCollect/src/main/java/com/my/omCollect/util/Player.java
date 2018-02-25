package com.my.omCollect.util;

public class Player {
	private String title;
	private String video_player;
	
	public Player(String title,String video_player) {
		this.title = title;
		this.video_player = video_player;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideo_player() {
		return video_player;
	}
	public void setVideo_player(String video_player) {
		this.video_player = video_player;
	}
	
}
