package com.example.miniprogect1.controller;

import com.example.miniprogect1.domain.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class MusicController {
    private MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping("/music/add")
    public void addMusicFiles(@RequestBody String directoryPath) {
        musicService.addMusicFiles(directoryPath);
    }
}
