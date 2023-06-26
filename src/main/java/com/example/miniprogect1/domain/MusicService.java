package com.example.miniprogect1.domain;

import com.example.miniprogect1.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class MusicService {


    private MusicRepository musicRepository;
    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public void addMusicFiles(String directoryPath) {
        File folder = new File(directoryPath);
        addFilesFromFolder(folder);
    }

    public void addFilesFromFolder(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                addFilesFromFolder(file);
            } else if (file.getName().endsWith(".m4p")) {
                Music music = new Music();
                music.setMusicTitle(file.getName());
                music.setMusicArtist(folder.getName());
                music.setMusicFilePath(file.getPath());
                musicRepository.save(music);
            }
        }
    }


}
