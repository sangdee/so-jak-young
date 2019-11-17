package com.cbnu.sjy_.core.controller;

import android.view.View;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.BaseController;
import com.cbnu.sjy_.core.logic.SignUpLogic;
import com.cbnu.sjy_.core.model.User;
import com.cbnu.sjy_.core.viewmodel.SignUpViewModel;
import com.cbnu.sjy_.databinding.SignUpView;
import com.cbnu.sjy_.util.Factory;

/**
 * @author : Sangji Lee
 * @when : 2019-11-15 오후 10:50
 * @homepage : https://github.com/sangji11
 */
public class SignUpController extends BaseController<SignUpView, SignUpViewModel> {

    private SignUpLogic signUp = Factory.createService(this, SignUpLogic.class);
    @Override
    protected int injectView() {return R.layout.view_signup;}

    @Override
    protected Class<SignUpViewModel> injectViewModel() {return SignUpViewModel.class;}

    public void onSignUpFinish() {
        User user = new User();
        user.setId(viewModel.getId());
        user.setPw(viewModel.getPw());
        user.setName(viewModel.getName());
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        signUp.sign(user);
    }
}
