package com.cbnu.sjy_.base.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.cbnu.sjy_.BR;
import com.cbnu.sjy_.base.viwemodel.BaseViewModel;

/**
 * @author : Sangji Lee
 * @when : 2019-11-25 오전 3:26
 * @homepage : https://github.com/sangji11
 */
@SuppressWarnings("unchecked")
public abstract class BaseFragmentController<V extends ViewDataBinding, VM extends BaseViewModel> extends Fragment {

    protected V view;
    protected VM viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = DataBindingUtil.inflate(inflater, injectView(), container, false);
        viewModel = getParentController().viewModel;
        view.setLifecycleOwner(this);
        view.setVariable(BR.viewModel, viewModel);
        view.setVariable(BR.controller, this);
        return view.getRoot();
    }

    protected abstract int injectView();

    public BaseController<V, VM> getParentController() {
        return (BaseController<V, VM>) getActivity();
    }
}
