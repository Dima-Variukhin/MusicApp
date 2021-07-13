package com.example.musicapp;

public class Album {
    private String artist;
    private String name;
    private String date;

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public Album(String artist, String name, String date) {
        this.artist = artist;
        this.name = name;
        this.date = date;
    }
}
