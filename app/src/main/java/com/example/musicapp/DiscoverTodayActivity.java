package com.example.musicapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DiscoverTodayActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private AudioManager audioManager;

    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private final MediaPlayer.OnCompletionListener onCompletionListener = rmp -> releaseMediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Bring me the Horizon", "Sleepwalking,", R.drawable.pp, R.raw.heavy));
        songs.add(new Song("Imagine Dragons", "Whatever it takes", R.drawable.whatever, R.raw.thunder));
        songs.add(new Song("Neffex", "Best of me", R.drawable.download, R.raw.drama));
        songs.add(new Song("EDEN", "909", R.drawable.maxresdefault, R.raw.drugs));
        songs.add(new Song("Hollywood Undead", "Bad Moon", R.drawable.unnamed, 0));
        songs.add(new Song("Hollywood Undead", "Bad Moon", R.drawable.unnamed, 0));
        songs.add(new Song("guardin", "make it out", R.drawable.guadr1, R.raw.oh));
        songs.add(new Song("guardin", "Solitary", R.drawable.guard2, 0));
        songs.add(new Song("guardin", "kinda sorta", R.drawable.guard3, 0));

        SongAdapter songAdapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            releaseMediaPlayer();

            Song song = songs.get(position);

            int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mediaPlayer = MediaPlayer.create(DiscoverTodayActivity.this, song.getAudio());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }
}
