package com.cbnu.sjy_.core.controller;

import android.content.Intent;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.cbnu.sjy_.core.model.entity.User;
import com.cbnu.sjy_.core.viewmodel.CompleteViewModel;
import com.cbnu.sjy_.databinding.CompleteView;
import com.cbnu.sjy_.util.Cache;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오후 3:35
 * @homepage : https://github.com/sangji11
 */
public class CompleteController extends BaseController<CompleteView, CompleteViewModel> {


    @Override
    protected int injectView() {
        return R.layout.view_complete;
    }

public void show(){
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        Movie movie = Cache.movieCache.get(id);


        viewModel.setMovieName(movie.getName());

    }public void showUser(){
        User user = Cache.userCache;
        viewModel.setStudent_num(user.getStudent_num());
        viewModel.setName(user.getName());
    }

    public void cancel() {
        dialog("예매취소", "예매를 취소하시겠습니까?", () -> startActivity(MainController.class));
    }

    public void confirm() {
        toast("예매가 완료 되었습니다.");
        startActivity(MainController.class);
    }
}
