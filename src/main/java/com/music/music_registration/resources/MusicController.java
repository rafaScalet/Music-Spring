package com.music.music_registration.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.music.music_registration.services.MusicService;
import com.music.music_registration.entities.Music;

@RestController
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

	@DeleteMapping("music/{id}")
	public void deleteMusic (@PathVariable int id) {
		this.service.deleteMusic(id);
	}

	@PostMapping("music")
	public Music saveMusic (@RequestBody Music music) {
		return this.service.saveMusic(music);
	}

	@PutMapping("music/{id}")
	public void updateMusic (@RequestBody Music music, @PathVariable int id) {
		this.service.updateMusic(id, music);
	}

}
