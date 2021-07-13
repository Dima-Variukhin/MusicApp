package com.example.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("guardin", "so that's it? huh", "2020"));
        albums.add(new Album("AC/DC", "Rock or Bust", "2014"));
        albums.add(new Album("grandson", "Rock Bottom", "2019"));

        ListView listView = findViewById(R.id.list);
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AlbumsActivity.this, ArtistsActivity.class);
            startActivity(intent);
        });
        listView.setAdapter(albumAdapter);

    }
}
