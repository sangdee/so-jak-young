package com.cbnu.sjy_.util;

import android.view.View;

import androidx.databinding.BindingAdapter;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class Binder {

    @BindingAdapter("onViewCreate")
    public static void onViewCreate(View view, View.OnClickListener listener) {
        if (view != null) listener.onClick(view);
    }
}