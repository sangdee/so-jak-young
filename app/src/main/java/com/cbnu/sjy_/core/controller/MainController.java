package com.cbnu.sjy_.core.controller;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.logic.MainLogic;
import com.cbnu.sjy_.core.model.entity.Item;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.cbnu.sjy_.core.viewmodel.MainViewModel;
import com.cbnu.sjy_.databinding.MainView;
import com.cbnu.sjy_.di.Factory;
import com.cbnu.sjy_.util.Cache;
import com.cbnu.sjy_.util.MainAdapter;
import com.cbnu.sjy_.util.OnXML;
import com.cbnu.sjy_.util.ScreeningAdapter;

import java.util.ArrayList;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class MainController extends BaseController<MainView, MainViewModel> {
    private MainLogic mainLogic = Factory.createTask(this, MainLogic.class);

    ArrayList<Item> movieList = new ArrayList<>();

    @Override
    protected int injectView() {
        return R.layout.view_main;
    }

    @OnXML(resid = R.layout.view_main)
    public void showScreening() {
        ViewPager vpPager = view.viewPager;
        vpPager.setAdapter(new ScreeningAdapter(getSupportFragmentManager()));
        view.indicator.setViewPager(vpPager);
        for (Movie m : Cache.movieCache) {
            if (!m.getScreening()) {
                movieList.add(new Item(m.getName(), m.getImageUrl()));
            }
        }

        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.row_view);
        MainAdapter adapter = new MainAdapter(getApplicationContext(), R.layout.view_rowmain, movieList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    @OnXML(resid = R.layout.view_rowmain)
    public void showInfo() {
        startActivity(SpecificController.class);
    }
}
