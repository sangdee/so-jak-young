package com.cbnu.sjy_.core.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.cbnu.sjy_.core.model.entity.TimeTableItem;
import com.cbnu.sjy_.core.viewmodel.ReservationViewModel;
import com.cbnu.sjy_.databinding.ReservationView;
import com.cbnu.sjy_.util.Cache;
import com.cbnu.sjy_.util.OnXML;
import com.cbnu.sjy_.util.TimeTableAdapter;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오전 1:27
 * @homepage : https://github.com/sangji11
 */
public class ReservationController extends BaseController<ReservationView, ReservationViewModel> {
    @Override
    protected int injectView() {
        return R.layout.view_reservation;
    }

    RecyclerView timetableView1, timetableView2;
    TimeTableAdapter adapter1, adapter2;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        movie = Cache.movieCache.get(id);
        viewModel.setName(movie.getName());


        timetableView1 = findViewById(R.id.timetableView312);
        timetableView2 = findViewById(R.id.timetableView507);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false); //레이아웃매니저 생성
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        timetableView1.setLayoutManager(layoutManager);
        timetableView2.setLayoutManager(layoutManager2);
        adapter1 = new TimeTableAdapter(getApplicationContext());
        adapter1.addItem(new TimeTableItem("11:00", "20석"));
        adapter1.addItem(new TimeTableItem("12:00", "20석"));
        adapter1.addItem(new TimeTableItem("15:00", "20석"));
        adapter1.addItem(new TimeTableItem("18:00", "20석"));
        adapter1.addItem(new TimeTableItem("21:00", "20석"));

        adapter2 = new TimeTableAdapter(getApplicationContext());
        adapter2.addItem(new TimeTableItem("12:00", "18석"));
        adapter2.addItem(new TimeTableItem("18:00", "20석"));

        timetableView1.setAdapter(adapter1);
        timetableView2.setAdapter(adapter2);
        view.date1.setOnClickListener(v -> view.date1.setSelected(!view.date1.isSelected()));
        view.date2.setOnClickListener(v -> view.date2.setSelected(!view.date2.isSelected()));
        view.date3.setOnClickListener(v -> view.date3.setSelected(!view.date3.isSelected()));
        view.date4.setOnClickListener(v -> view.date4.setSelected(!view.date4.isSelected()));

    }


    @OnXML(resid = R.layout.view_reservation)
    public void onCilckedConfirm() {
        dialog(movie.getName(), movie.getName() + "을 예약하시겠습니까?", () ->
                startActivity(CompleteController.class));
    }
}

