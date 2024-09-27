package com.music.music_registration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.music_registration.entities.Music;

public interface MusicRepository extends JpaRepository<Music, Integer> {

}
