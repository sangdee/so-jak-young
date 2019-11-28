package com.cbnu.sjy_.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.core.controller.SpecificController;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Sangji Lee
 * @when : 2019-11-27 오전 11:20
 * @homepage : https://github.com/sangji11
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Movie> movies;
    private Context context;

    public MainAdapter(Context context, List<Movie> movie) {
        List<Movie> movies = new ArrayList<>();
        for (Movie m : movie) {
            if (!m.getScreening()) {
                movies.add(m);
            }
        }
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rowmain, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.with(context)
                .load(movies.get(position).getImageUrl())
                .into(holder.movie_img);

        holder.movie_name.setText(movies.get(position).getName());
        holder.movie_name.setOnClickListener(v -> moveSpec(movies.get(position).getId()));
        holder.movie_img.setOnClickListener(v -> moveSpec(movies.get(position).getId()));
    }

    private void moveSpec(int movieId) {
        Intent intent = new Intent(context, SpecificController.class);
        intent.putExtra("id", movieId);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView movie_name;
        private ImageView movie_img;

        ViewHolder(View view) {
            super(view);
            movie_name = view.findViewById(R.id.movie_name);
            movie_img = view.findViewById(R.id.movie_img);
        }
    }
}
