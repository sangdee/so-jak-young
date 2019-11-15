package com.cbnu.sjy_.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import com.cbnu.sjy_.BR;
import com.cbnu.sjy_.base.extensions.UIExtension;
import com.cbnu.sjy_.util.Factory;

/**
 * 액티비티의 라이프사이클을 새로 정의하는 Activity Hierarchy
 * view 와 viewModel 을 하위클래스로부터 주입(inject)받음
 * 하위 클래스는 두 메소드를 반드시 구현해야함. (템플릿 메소드 패턴)
 */
public abstract class BaseController<V extends ViewDataBinding, VM extends ViewModel>
        extends UIExtension {

    protected V view;
    protected VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = DataBindingUtil.setContentView(this, injectView());
        viewModel = Factory.createView(this, injectViewModel());
        view.setVariable(BR.view, view);
        view.setVariable(BR.controller, this);
    }

    /**
     * 뷰를 주입하는 메소드
     */
    protected abstract int injectView();

    /**
     * 뷰모델을 주입하는 메소드
     */
    protected abstract Class<VM> injectViewModel();

}
