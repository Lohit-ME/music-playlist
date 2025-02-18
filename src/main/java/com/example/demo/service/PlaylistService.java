package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Playlist;
import com.example.demo.repository.PlaylistRepository;


@Service
public class PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistrepository;
	
//	this method is used to show\display all the products
	public List<Playlist> findAllPlaylist(){
		
		return playlistrepository.findAll();
	}
	
//	this method is used to store the products into the db
	
	public Playlist savePlaylist(Playlist playlist) {
		
		return playlistrepository.save(playlist);
	}
//	to update products using its own ids

//	update products set name="samsung" where id=111;
	
	public Playlist editById(Long id) {
		
		
		Optional<Playlist> optionalPlaylist= playlistrepository.findById(id);
	
//		orElse(null),in some case,the products/id is not present,it will return null
		return optionalPlaylist.orElse(null);
		
	}
		
		public void deletePlaylist(Long id) {
			
			 playlistrepository.deleteById(id);
		}
	}


