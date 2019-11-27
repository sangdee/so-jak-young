package com.cbnu.sjy_.core.controller;

import android.content.Intent;

import com.bumptech.glide.Glide;
import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseFragmentController;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.cbnu.sjy_.core.viewmodel.MainViewModel;
import com.cbnu.sjy_.databinding.ScreeningView;
import com.cbnu.sjy_.util.Cache;
import com.cbnu.sjy_.util.OnXML;

/**
 * @author : Sangji Lee
 * @when : 2019-11-25 오전 3:47
 * @homepage : https://github.com/sangji11
 */
public class ScreeningController extends BaseFragmentController<ScreeningView, MainViewModel> {

    @Override
    protected int injectView() {
        return R.layout.fragment_screening;
    }

    @OnXML(resid = R.layout.fragment_screening)
    public void showImage() {
        Movie movie = Cache.movieCache.get(getArguments().getInt("movieId"));
        Glide.with(this)
                .load(movie.getImageUrl())
                .into(view.imageView);

    }

    @OnXML(resid = R.layout.fragment_screening)
    public void showInfo() {
        int movieId = getArguments().getInt("movieId");
        Intent intent = new Intent(getContext(), SpecificController.class);
        intent.putExtra("id", movieId);
        startActivity(intent);
    }

}

