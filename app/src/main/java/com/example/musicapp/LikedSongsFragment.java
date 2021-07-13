package com.example.musicapp;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class LikedSongsFragment extends Fragment {

    public LikedSongsFragment() {
    }

    private MediaPlayer mediaPlayer;

    private AudioManager audioManager;

    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener onCompletionListener = mediaPlayer -> releaseMediaPlayer();

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_items, container, false);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Pornofilmy", "Система", R.drawable.pp, R.raw.system));
        songs.add(new Song("Bring me the Horizon", "Oh No", R.drawable.ohno, R.raw.oh));
        songs.add(new Song("Bring me the Horizon", "Heavy metal", R.drawable.heavy, R.raw.heavy));
        songs.add(new Song("Jesse", "Drama", R.drawable.drama, R.raw.drama));
        songs.add(new Song("Our Last Night", "Sunrise", R.drawable.sunrise, R.raw.sunrise));
        songs.add(new Song("brakence", "sunder", R.drawable.brake, R.raw.sunder));
        songs.add(new Song("Imagine Dragons", "Thunder", R.drawable.image, R.raw.thunder));
        songs.add(new Song("EDEN", "drugs", R.drawable.drugs, R.raw.drugs));

        SongAdapter songAdapter = new SongAdapter(getActivity(), songs);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            releaseMediaPlayer();
            Song song = songs.get(position);

            int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mediaPlayer = MediaPlayer.create(getActivity(), song.getAudio());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
        return rootView;
    }
}
