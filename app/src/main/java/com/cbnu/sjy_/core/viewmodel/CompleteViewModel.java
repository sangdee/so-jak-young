package com.cbnu.sjy_.core.viewmodel;

import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.util.Data;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오후 3:36
 * @homepage : https://github.com/sangji11
 */
public class CompleteViewModel extends BaseViewModel {
    private Data<String> movieName = new Data<>();
    private Data<String> name = new Data<>();
    private Data<String> student_num = new Data<>();

    public Data<String> getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName.setValue(movieName);
    }

    public Data<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public Data<String> getStudent_num() {
        return student_num;
    }

    public void setStudent_num(String student_num) {
        this.student_num.setValue(student_num);
    }

}
