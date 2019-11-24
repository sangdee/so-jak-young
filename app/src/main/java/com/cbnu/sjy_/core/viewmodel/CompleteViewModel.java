package com.cbnu.sjy_.core.viewmodel;

import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.util.Data;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오후 3:36
 * @homepage : https://github.com/sangji11
 */
public class CompleteViewModel extends BaseViewModel {
    private Data<String> name = new Data<>();
    private Data<String> student_num = new Data<>();

    public Data<String> getName() {
        return name;
    }

    public void setName(Data<String> name) {
        this.name = name;
    }

    public Data<String> getStudent_num() {
        return student_num;
    }

    public void setStudent_num(Data<String> student_num) {
        this.name = student_num;
    }

}
