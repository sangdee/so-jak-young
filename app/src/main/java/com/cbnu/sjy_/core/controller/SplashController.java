package com.cbnu.sjy_.core.controller;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.logic.SplashLogic;
import com.cbnu.sjy_.core.viewmodel.SplashViewModel;
import com.cbnu.sjy_.databinding.SplashView;
import com.cbnu.sjy_.di.Factory;
import com.cbnu.sjy_.util.OnXML;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class SplashController extends BaseController<SplashView, SplashViewModel> {

    private SplashLogic splashLogic = Factory.createTask(this, SplashLogic.class);

    @Override
    protected int injectView() {
        return R.layout.view_splash;
    }

    @OnXML(resid = R.layout.view_splash)
    public void splash() {
        splashLogic.splash();
    }
}
