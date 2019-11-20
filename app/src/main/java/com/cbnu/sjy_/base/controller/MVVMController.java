package com.cbnu.sjy_.base.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;

import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.di.ViewModelFactory;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public abstract class MVVMController<V extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    protected V view;

    protected VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = DataBindingUtil.setContentView(this, injectView());
        viewModel = ViewModelFactory.createViewModel(this, injectViewModel());
        view.setLifecycleOwner(this);
        view.setVariable(BR.viewModel, viewModel);
        view.setVariable(BR.controller,this);
    }

    protected abstract int injectView();

    protected abstract Class<VM> injectViewModel();

}
