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

	public Music saveMusic (Music music) {
		return this.repository.save(music);
	}

	public void updateMusic (int id, Music music) {
		Music temp = repository.getReferenceById(id);

		temp.setAlbum(music.getAlbum());
		temp.setComposer(music.getComposer());
		temp.setDuration(music.getDuration());
		temp.setGenre(music.getGenre());
		temp.setName(music.getName());

		repository.save(temp);
	}

}
