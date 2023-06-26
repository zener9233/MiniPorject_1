package com.example.miniprogect1.repository;

import com.example.miniprogect1.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

}
