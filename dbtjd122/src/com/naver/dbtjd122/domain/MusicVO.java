package com.naver.dbtjd122.domain;

public class MusicVO {
	private int num; 
	private String image; 
	private String song; 
	private String singer;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "MusicVO [num=" + num + ", image=" + image + ", song=" + song + ", singer=" + singer + "]";
	}
	
}
