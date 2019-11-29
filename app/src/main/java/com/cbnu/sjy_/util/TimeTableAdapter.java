package com.cbnu.sjy_.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.core.model.entity.TimeTableItem;

import java.util.ArrayList;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.ViewHolder> {

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
    public TimeTableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_timetable, parent, false);
        return new TimeTableAdapter.ViewHolder(view);
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
