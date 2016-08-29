package com.training.android.basicadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.android.basicadapters.R;
import com.training.android.basicadapters.models.Movie;

import java.util.List;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private Context     mContext;
    private int         mResource;
    private List<Movie> mMovies;

    public MoviesAdapter(Context context, int resource, List<Movie> movies) {
        super(context, resource, movies);

        mContext = context;
        mResource = resource;
        mMovies = movies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Movie movie = mMovies.get(position);
        if (movie != null) {
            if (holder.tvTitle != null) {
                holder.tvTitle.setText(movie.getTitle());
            }
            if (holder.tvGenre != null) {
                holder.tvGenre.setText(movie.getGenre());
            }
            if (holder.imgMovie != null) {
                holder.imgMovie.setImageResource(movie.getImageId());
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView  tvTitle;
        TextView  tvGenre;
        ImageView imgMovie;

        public ViewHolder(View view) {
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvGenre = (TextView) view.findViewById(R.id.tvGenre);
            imgMovie = (ImageView) view.findViewById(R.id.imgMovie);
        }
    }
}
