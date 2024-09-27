package com.music.music_registration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.music_registration.entities.Music;
import com.music.music_registration.repositories.MusicRepository;


public class MusicService {

	@Autowired
	private MusicRepository repository;

	public List<Music> getMusics () {
		return this.repository.findAll();
	}

}
