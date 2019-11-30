package com.cbnu.sjy_.util.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cbnu.sjy_.core.controller.ScreeningController;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.cbnu.sjy_.util.Cache;

import java.util.ArrayList;

/**
 * @author : Sangji Lee
 * @when : 2019-11-25 오전 3:30
 * @homepage : https://github.com/sangji11
 */
public class ScreeningAdapter extends FragmentPagerAdapter {

    private int numOfScreening = 0;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public ScreeningAdapter(FragmentManager fm) {
        super(fm);

        for (Movie m : Cache.movieCache) {
            if (m.getScreening() ) {
                numOfScreening++;
                ScreeningController screeningController = new ScreeningController();
                Bundle args = new Bundle();
                args.putInt("movieId", m.getId());
                screeningController.setArguments(args);
                fragments.add(screeningController);

            }
        }
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return numOfScreening;
    }
}
