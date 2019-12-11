package com.example.git1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.git1.R;
import com.example.git1.entity.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    //private static final String TAG = "llllll";
    private Context context;
    private List<Movie> movies = new ArrayList<>();

    // list {movie1, movie2, movie3} list.get(0).
    //movie1.
    public RVAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath()).into(holder.movie_now_playing_iv);

        holder.movie_now_playing_tittle.setText(movies.get(position).getTitle());
        holder.movie_now_playing_date_release.setText(movies.get(position).getReleaseDate());
        holder.movie_now_playing_overview.setText(movies.get(position).getOverview());


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setList(List<Movie> movies) {

        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ImageView movie_now_playing_iv;
        public TextView movie_now_playing_tittle;
        public TextView movie_now_playing_overview;
        public TextView movie_now_playing_date_release;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movie_now_playing_iv = itemView.findViewById(R.id.movie_now_playing_iv);
            movie_now_playing_tittle = itemView.findViewById(R.id.movie_now_playing_tittle);
            movie_now_playing_overview = itemView.findViewById(R.id.movie_now_playing_overview);
            movie_now_playing_date_release = itemView.findViewById(R.id.movie_now_playing_date_release);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

        }
    }


}
