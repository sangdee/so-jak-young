package com.cbnu.sjy_.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;

import com.cbnu.sjy_.base.controller.MVVMController;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class ViewModelFactory {

    public static <M extends ViewModel> M createViewModel(MVVMController owner, Class<M> clazz) {
        return new ViewModelProvider(owner, new NewInstanceFactory()).get(clazz);
    }
}
