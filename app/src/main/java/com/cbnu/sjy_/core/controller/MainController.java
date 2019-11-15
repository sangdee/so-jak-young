package com.cbnu.sjy_.core.controller;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.BaseController;
import com.cbnu.sjy_.core.viewmodel.MainViewModel;
import com.cbnu.sjy_.databinding.MainView;

public class MainController extends BaseController<MainView, MainViewModel> {

    @Override
    protected int injectView() {
        return R.layout.view_main;
    }

    @Override
    protected Class<MainViewModel> injectViewModel() {
        return MainViewModel.class;
    }
}
