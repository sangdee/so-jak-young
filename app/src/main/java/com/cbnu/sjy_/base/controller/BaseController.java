package com.cbnu.sjy_.base.controller;

import android.app.AlertDialog;
import android.widget.Toast;

import androidx.databinding.ViewDataBinding;

import com.cbnu.sjy_.base.viwemodel.BaseViewModel;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public abstract class BaseController<V extends ViewDataBinding, VM extends BaseViewModel> extends ExtendedController<V, VM> {

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void dialog(String title, String msg, Runnable positive) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)
                                .setPositiveButton("확인", (dialog, which) -> positive.run())
                .setNegativeButton("취소", (dialog, which) -> {
                })
                .setCancelable(false)
                .create()
                .show();
    }

    public void showProgress() {
        viewModel.showProgress();
    }

    public void hideProgress() {
        viewModel.hideProgress();
    }

    public void hideAndToast(String msg) {
        hideProgress();
        toast(msg);
    }
}
