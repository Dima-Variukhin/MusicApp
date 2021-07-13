package com.example.musicapp;

public class Artist {
    private String artist;
    private String genre;

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public Artist(String artist, String genre) {
        this.artist = artist;
        this.genre = genre;
    }
}
