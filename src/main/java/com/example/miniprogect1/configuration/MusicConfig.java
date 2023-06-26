package com.example.miniprogect1.configuration;

import com.example.miniprogect1.domain.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicConfig {
    @Autowired
    private MusicService musicService;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            String musicDirectoryPath = "/Users/iyeong-eun/Desktop/BGMList/싸이월드BGMList";
            musicService.addMusicFiles(musicDirectoryPath);
        };
    }
}
