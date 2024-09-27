package com.music.music_registration.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.music.music_registration.services.MusicService;
import com.music.music_registration.entities.Music;

public class MusicController {

	@Autowired
	private MusicService service;

	@GetMapping("musics")
	public List<Music> getMusics () {
		return this.service.getMusics();
	}

	@GetMapping("music/{id}")
	public Music getMusicById (@PathVariable int id) {
		return this.service.getMusicById(id);
	}

}
