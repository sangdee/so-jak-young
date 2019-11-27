package com.cbnu.sjy_.core.viewmodel;

import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.util.Data;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class MainViewModel extends BaseViewModel {

    private Data<String> id = new Data<>();
    private Data<String> pw = new Data<>();
    private Data<String> name = new Data<>();
    private Data<String> movieName = new Data<>();

    public void setMovieName(Data<String> movieName) {
        this.movieName = movieName;
    }

    public Data<String> getMovieName() {
        return movieName;
    }

    public Data<String> getId() {
        return id;
    }

    public Data<String> getPw() {
        return pw;
    }

    public Data<String> getName() {
        return name;
    }
}
