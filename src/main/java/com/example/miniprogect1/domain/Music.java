package com.example.miniprogect1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "M_List")
@Data
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //고유번호
    @Column(name = "music_id")
    private Long id;

    //음악명
    @Column(name = "music_title")
    private String musicTitle;
    //가수명
    @Column(name = "music_artist")
    private String musicArtist;
    //파일
    @Column(name = "music_filepath")
    private String musicFilePath;

    // 생성자, getter, setter, toString 등의 메서드 추가

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public String getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }

    public String getMusicFilePath() {
        return musicFilePath;
    }

    public void setMusicFilePath(String musicFilePath) {
        this.musicFilePath = musicFilePath;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", musicTitle='" + musicTitle + '\'' +
                ", musicArtist='" + musicArtist + '\'' +
                ", musicFilePath='" + musicFilePath + '\'' +
                '}';
    }
}
