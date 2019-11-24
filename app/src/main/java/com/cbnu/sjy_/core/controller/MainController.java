package com.cbnu.sjy_.core.controller;

import androidx.viewpager.widget.ViewPager;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.viewmodel.MainViewModel;
import com.cbnu.sjy_.databinding.MainView;
import com.cbnu.sjy_.util.OnXML;
import com.cbnu.sjy_.util.ScreeningAdapter;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class MainController extends BaseController<MainView, MainViewModel> {

    @Override
    protected int injectView() {
        return R.layout.view_main;
    }

    @OnXML(resid = R.layout.view_main)
    public void showInfo() {
        ViewPager vpPager = view.viewPager;
        vpPager.setAdapter(new ScreeningAdapter(getSupportFragmentManager()));
        view.indicator.setViewPager(vpPager);
    }
}

