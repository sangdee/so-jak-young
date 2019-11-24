package com.cbnu.sjy_.core.controller;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.logic.LoginLogic;
import com.cbnu.sjy_.core.model.entity.User;
import com.cbnu.sjy_.core.viewmodel.LoginViewModel;
import com.cbnu.sjy_.databinding.LoginView;
import com.cbnu.sjy_.di.Factory;
import com.cbnu.sjy_.util.OnXML;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public class LoginController extends BaseController<LoginView, LoginViewModel> {

    private LoginLogic loginLogic = Factory.createTask(this, LoginLogic.class);

    @Override
    protected int injectView() {
        return R.layout.view_login;
    }

    @OnXML(resid = R.layout.view_login)

    public void onLoginClicked() {
        User user = new User();
        user.setId(viewModel.getId().getValue());
        user.setPw(viewModel.getPw().getValue());
        loginLogic.signIn(user, viewModel.getStay());
    }

    @OnXML(resid = R.layout.view_login)
    public void onSignUpClicked() {
        startActivity(SignUpController.class);
    }
}