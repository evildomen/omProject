package com.my.omCollect.util;

public class Video {
	private String video_id;
	private String video_div_add;
	private String video_add;
	private String video_img;
	private String video_title;

	public Video(String video_id, String video_div_add, String video_add, String video_img, String video_title) {
		this.video_id = video_id;
		this.video_div_add = video_div_add;
		this.video_add = video_add;
		this.video_img = video_img;
		this.video_title = video_title;
	}
	public Video(String video_id, String video_add, String video_img, String video_title) {
		this.video_id = video_id;
		this.video_add = video_add;
		this.video_img = video_img;
		this.video_title = video_title;
	}
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getVideo_div_add() {
		return video_div_add;
	}

	public void setVideo_div_add(String video_div_add) {
		this.video_div_add = video_div_add;
	}

	public String getVideo_add() {
		return video_add;
	}

	public void setVideo_add(String video_add) {
		this.video_add = video_add;
	}

	public String getVideo_img() {
		return video_img;
	}

	public void setVideo_img(String video_img) {
		this.video_img = video_img;
	}

	public String getVideo_title() {
		return video_title;
	}

	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}

	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", video_div_add=" + video_div_add + ", video_add=" + video_add
				+ ", video_img=" + video_img + ", video_title=" + video_title + "]";
	}

}
