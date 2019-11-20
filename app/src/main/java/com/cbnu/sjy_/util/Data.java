package com.cbnu.sjy_.util;

import androidx.lifecycle.MutableLiveData;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class Data<T> extends MutableLiveData<T> {

    public Data() {
    }

    public Data(T t) {
        setValue(t);
    }
}
