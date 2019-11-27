package com.cbnu.sjy_.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cbnu.sjy_.R;
import com.cbnu.sjy_.core.model.entity.Item;

import java.util.ArrayList;

/**
 * @author : Sangji Lee
 * @when : 2019-11-27 오전 11:20
 * @homepage : https://github.com/sangji11
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<Item> movie;
    private int itemLayout;
    private Context context;

    public MainAdapter(Context context, int itemLayout, ArrayList<Item> movie) {
        this.movie = movie;
        this.itemLayout = itemLayout;
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
        Glide.with(context)
                .load(movie.get(position).getImage())
                .into(holder.movie_img);
        holder.movie_name.setText(movie.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView movie_name;
        private ImageView movie_img;

        public ViewHolder(View view) {
            super(view);

            movie_name = view.findViewById(R.id.movie_name);
            movie_img = view.findViewById(R.id.movie_img);
        }
    }
}
