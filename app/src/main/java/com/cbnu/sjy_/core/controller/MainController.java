package com.cbnu.sjy_.core.controller;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.model.cache.UserCache;
import com.cbnu.sjy_.core.model.entity.UserEntity;
import com.cbnu.sjy_.core.viewmodel.MainViewModel;
import com.cbnu.sjy_.databinding.MainView;
import com.cbnu.sjy_.util.OnXML;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class MainController extends BaseController<MainView, MainViewModel> {

    @Override protected int injectView() {
        return R.layout.view_main;
    }

    @Override protected Class<MainViewModel> injectViewModel() {
        return MainViewModel.class;
    }

    @OnXML(resid = R.layout.view_main)
    public void showInfo() {
        UserCache cache = UserCache.getInstance();
        UserEntity user = cache.read();

        viewModel.getId().setValue(user.getId());
        viewModel.getName().setValue(user.getName());
        viewModel.getPw().setValue(user.getPw());
    }
}
