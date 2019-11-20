package com.cbnu.sjy_.core.viewmodel;


import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.util.Data;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class LoginViewModel extends BaseViewModel {
    private Data<String> id = new Data<>();
    private Data<String> pw = new Data<>();
    private Data<Boolean> stay = new Data<>(false);

    public Data<String> getId() {
        return id;
    }

    public Data<String> getPw() {
        return pw;
    }

    public Data<Boolean> getStay() {
        return stay;
    }

    public void setId(Data<String> id) {
        this.id = id;
    }

    public void setPw(Data<String> pw) {
        this.pw = pw;
    }

    public void setStay(Data<Boolean> stay) {
        this.stay = stay;
    }
}
