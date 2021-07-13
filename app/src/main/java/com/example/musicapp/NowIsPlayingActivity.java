package com.example.musicapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NowIsPlayingActivity extends AppCompatActivity {
    int i;
    int premium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);

        ImageView play = findViewById(R.id.playButton);
        play.setOnClickListener(v -> {
            if (i == 0) {
                Toast.makeText(getApplicationContext(), "Playing" + "\"Code Red\"", Toast.LENGTH_SHORT).show();
                i++;
            } else {
                Toast.makeText(getApplicationContext(), "Stopped", Toast.LENGTH_SHORT).show();
                i = 0;
            }
        });

        ImageView next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            if (premium < 7) {
                Toast.makeText(getApplicationContext(), "next song", Toast.LENGTH_SHORT).show();
                premium++;
            } else {
                Toast.makeText(getApplicationContext(), "Buy Premium", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView previous = findViewById(R.id.previous);
        previous.setOnClickListener(v -> {
            if (premium < 7) {
                Toast.makeText(getApplicationContext(), "previous song", Toast.LENGTH_SHORT).show();
                premium++;
            } else {
                Toast.makeText(getApplicationContext(), "Buy Premium", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView like = findViewById(R.id.like);
        like.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Added to liked songs", Toast.LENGTH_SHORT).show();
        });

        ImageView shuffle = findViewById(R.id.shuffle);
        shuffle.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "shuffle", Toast.LENGTH_SHORT).show();
        });

    }
}
