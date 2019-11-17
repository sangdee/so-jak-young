package com.cbnu.sjy_.core.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author : Sangji Lee
 * @when : 2019-11-15 오후 10:50
 * @homepage : https://github.com/sangji11
 */
public class SignUpViewModel extends ViewModel {
    private MutableLiveData<String> id = new MutableLiveData<>();
    private MutableLiveData<String> pw = new MutableLiveData<>();
    private MutableLiveData<String> name = new MutableLiveData<>();

    public String getId() { return id.getValue();}

    public void setId(String id) {
        this.id.setValue(id);
    }

    public String getPw() {
        return pw.getValue();
    }

    public void setPw(String pw) {
        this.pw.setValue(pw);
    }

    public String getName(){ return name.getValue(); }

    public void setName(String name){ this.name.setValue(name); }
}
