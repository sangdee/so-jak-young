package com.cbnu.sjy_.base.viwemodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.cbnu.sjy_.util.Data;


/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public class BaseViewModel extends ViewModel {
    private Data<Integer> progressBar = new Data<>(View.GONE);

    public Data<Integer> getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(Data<Integer> progressBar) {
        this.progressBar = progressBar;
    }

    public void showProgress() {
        this.progressBar.setValue(View.VISIBLE);
    }

    public void hideProgress() {
        this.progressBar.setValue(View.GONE);
    }
}
