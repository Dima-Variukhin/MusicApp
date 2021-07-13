package com.example.musicapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AlbumAdapter extends ArrayAdapter<Album> {
    public AlbumAdapter(Context context, List<Album> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items_album, parent, false);
        }
        Album album = getItem(position);

        TextView artist = listItemView.findViewById(R.id.artistName);
        artist.setText(album.getArtist());

        TextView albumName = listItemView.findViewById(R.id.albumName);
        albumName.setText(album.getName());

        TextView date = listItemView.findViewById(R.id.date);
        date.setText(album.getDate());

        return listItemView;
    }
}
