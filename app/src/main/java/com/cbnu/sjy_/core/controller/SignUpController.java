package com.cbnu.sjy_.core.controller;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.logic.SignUpLogic;
import com.cbnu.sjy_.core.model.entity.UserEntity;
import com.cbnu.sjy_.core.viewmodel.SignUpViewModel;
import com.cbnu.sjy_.databinding.SignUpView;
import com.cbnu.sjy_.di.Factory;
import com.cbnu.sjy_.util.OnXML;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class SignUpController extends BaseController<SignUpView, SignUpViewModel> {

    private SignUpLogic signUpTask = Factory.createTask(this, SignUpLogic.class);

    @Override protected int injectView() {
        return R.layout.view_signup;
    }

    @Override protected Class<SignUpViewModel> injectViewModel() {
        return SignUpViewModel.class;
    }

    @OnXML(resid = R.layout.view_signup)
    public void onSignUpFinish() {
        UserEntity user = new UserEntity();
        user.setId(viewModel.getId().getValue());
        user.setPw(viewModel.getPw().getValue());
        user.setName(viewModel.getName().getValue());
        signUpTask.signUp(user);
    }
}
