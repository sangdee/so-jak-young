package com.cbnu.sjy_.core.controller;

import android.content.Intent;

import com.bumptech.glide.Glide;
import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.cbnu.sjy_.core.viewmodel.SpecificViewModel;
import com.cbnu.sjy_.databinding.SpecificView;
import com.cbnu.sjy_.util.Cache;
import com.cbnu.sjy_.util.OnXML;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오전 12:31
 * @homepage : https://github.com/sangji11
 */

public class SpecificController extends BaseController<SpecificView, SpecificViewModel> {
    @Override
    protected int injectView() {
        return R.layout.view_spec;
    }

    @OnXML(resid = R.layout.view_spec)
    public void showSpec() {
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        Movie movie = Cache.movieCache.get(id);
        Glide.with(this)
                .load(movie.getImageUrl())
                .into(view.imageView);
        viewModel.setStroy(movie.getStory());
        viewModel.setName(movie.getName());
        viewModel.setDirector(movie.getDirectors());

    }
}
