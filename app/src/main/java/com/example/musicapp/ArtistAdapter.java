package com.example.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArtistAdapter extends ArrayAdapter<Artist> {
    public ArtistAdapter(Context context, List<Artist> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items_artist, parent, false);
        }
        Artist artist = getItem(position);

        TextView artisName = listItemView.findViewById(R.id.artistName);
        artisName.setText(artist.getArtist());

        TextView artistGenre = listItemView.findViewById(R.id.genre);
        artistGenre.setText(artist.getGenre());

        return listItemView;
    }
}
