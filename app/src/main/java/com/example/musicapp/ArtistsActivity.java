package com.example.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("guardin", "Rap"));
        artists.add(new Artist("Rise Against", "Rock"));
        artists.add(new Artist("Bring me the Horizon", "Rock"));

        ArtistAdapter artistAdapter = new ArtistAdapter(this, artists);
        ListView listView = findViewById(R.id.list);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ArtistsActivity.this, AlbumsActivity.class);
            startActivity(intent);
        });
        listView.setAdapter(artistAdapter);
    }
}
