package com.cbnu.sjy_.core.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<String> id;
    private MutableLiveData<String> pw;

    public String getId() {
        return id.getValue();
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public String getPw() {
        return pw.getValue();
    }

    public void setPw(String pw) {
        this.pw.setValue(pw);
    }
}

