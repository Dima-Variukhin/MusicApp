package com.example.musicapp;

import android.widget.ImageView;

public class Song {
    private String artist;
    private String name;
    private int image;
    private int audio;

    public int getAudio() {
        return audio;
    }

    public int getImage() {
        return image;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public Song(String artist, String name, int image, int audio) {
        this.artist = artist;
        this.name = name;
        this.image = image;
        this.audio = audio;
    }
}
