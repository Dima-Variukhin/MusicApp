package com.example.musicapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, List<Song> objects) {
        super(context, 0, objects);
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }
        Song song = getItem(position);

        TextView artist = listItemView.findViewById(R.id.artistName);
        artist.setText(song.getArtist());

        TextView songName = listItemView.findViewById(R.id.songName);
        songName.setText(song.getName());

        ImageView image = listItemView.findViewById(R.id.list_item_icon);
        image.setImageResource(song.getImage());


        return listItemView;
    }
}
