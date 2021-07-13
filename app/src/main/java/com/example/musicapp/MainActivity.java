package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nowIsPlaying = findViewById(R.id.nowIsPlaying);
        TextView likedSongs = findViewById(R.id.likedSongs);
        TextView albums = findViewById(R.id.albums);
        TextView artists = findViewById(R.id.artists);
        TextView discoverToday = findViewById(R.id.discover);

        nowIsPlaying.setOnClickListener(v -> {
            Intent now = new Intent(MainActivity.this, NowIsPlayingActivity.class);
            startActivity(now);
        });

        likedSongs.setOnClickListener(v -> {
            Intent liked = new Intent(MainActivity.this, LikedSongsActivity.class);
            startActivity(liked);
        });

        albums.setOnClickListener(v -> {
            Intent album = new Intent(MainActivity.this, AlbumsActivity.class);
            startActivity(album);
        });

        artists.setOnClickListener(v -> {
            Intent artist = new Intent(MainActivity.this, ArtistsActivity.class);
            startActivity(artist);
        });

        discoverToday.setOnClickListener(v -> {
            Intent discover = new Intent(MainActivity.this, DiscoverTodayActivity.class);
            startActivity(discover);
        });
    }
}