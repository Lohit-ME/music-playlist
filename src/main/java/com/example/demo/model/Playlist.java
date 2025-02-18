package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Playlist {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long song_id;
	
	
	private String song_name;
	private String song_img;
	private String Duration;
	public long getSong_id() {
		return song_id;
	}
	public void setSong_id(long song_id) {
		this.song_id = song_id;
	}
	
	public String getSong_name() {
		return song_name;
	}
	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	public String getSong_img() {
		return song_img;
	}
	public void setSong_img(String song_img) {
		this.song_img = song_img;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
}
