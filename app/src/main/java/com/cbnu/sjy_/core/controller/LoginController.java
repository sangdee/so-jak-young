package com.cbnu.sjy_.core.controller;

import android.view.View;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.BaseController;
import com.cbnu.sjy_.core.logic.AuthLogic;
import com.cbnu.sjy_.core.model.User;
import com.cbnu.sjy_.core.viewmodel.LoginViewModel;
import com.cbnu.sjy_.databinding.LoginView;
import com.cbnu.sjy_.util.Factory;

public class LoginController extends BaseController<LoginView, LoginViewModel> {

    private AuthLogic auth = Factory.createService(this, AuthLogic.class);

    @Override
    protected int injectView() {
        return R.layout.view_login;
    }

    @Override
    protected Class<LoginViewModel> injectViewModel() {
        return LoginViewModel.class;
    }

    public void onLoginClicked() {
        User user = new User();
        user.setId(viewModel.getId());
        user.setPw(viewModel.getPw());
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        auth.login(user);
    }
    public void onSignUpClicked(){
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        startActivity(SignUpController.class);
    }
}
