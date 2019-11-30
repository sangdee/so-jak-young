package com.cbnu.sjy_.util.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cbnu.sjy_.R;
import com.cbnu.sjy_.core.controller.SpecificController;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.cbnu.sjy_.core.model.entity.TimeTableItem;

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
        Glide.with(context)
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

    public static class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.ViewHolder> {

        public interface OnItemClickListener {
            void onItemClick(ViewHolder holder, View view, int position);
        }

        private Context context;
        private ArrayList<TimeTableItem> items = new ArrayList<>();
        private OnItemClickListener listener;

        public TimeTableAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_timetable, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {


            TimeTableItem item = items.get(position);
            viewHolder.setItem(item);
            viewHolder.setOnItemClickListener(listener);
            viewHolder.btn.setOnClickListener(v->viewHolder.btn.setSelected(!viewHolder.btn.isSelected()));

        }

        public void addItem(TimeTableItem item) {
            items.add(item);
        }

        public void addItems(ArrayList<TimeTableItem> items) {
            this.items = items;
        }


        public TimeTableItem getItem(int position) {
            return items.get(position);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView time, seats;
            LinearLayout btn;
            OnItemClickListener listenr;

            ViewHolder(@NonNull final View itemView) {
                super(itemView);
                btn = itemView.findViewById(R.id.btn);
                time = itemView.findViewById(R.id.time);
                seats = itemView.findViewById(R.id.seats);

                itemView.setOnClickListener(v -> {
                    int position = getAdapterPosition();
                    if (listenr != null) {
                        listenr.onItemClick(ViewHolder.this, itemView, position);
                    }
                });
            }

            public void setItem(TimeTableItem item) {
                time.setText(item.getTime());
                seats.setText(item.getSeat());
            }

            public void setOnItemClickListener(OnItemClickListener listenr) {
                this.listenr = listenr;
            }
        }
    }
}
