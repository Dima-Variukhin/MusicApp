package com.example.musicapp;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LikedSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new LikedSongsFragment())
                .commit();
    }
}
