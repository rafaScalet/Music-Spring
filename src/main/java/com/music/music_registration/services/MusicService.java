package com.music.music_registration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.music_registration.entities.Music;
import com.music.music_registration.repositories.MusicRepository;

import jakarta.persistence.EntityNotFoundException;


public class MusicService {

	@Autowired
	private MusicRepository repository;

	public List<Music> getMusics () {
		return this.repository.findAll();
	}

	public Music getMusicById (int id) {
		return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Music not found"));
	}

	public void deleteMusic (int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return;
		}

		throw new EntityNotFoundException("Music not found");
	}

}
