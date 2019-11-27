package com.cbnu.sjy_.core.viewmodel;

import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.util.Data;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오전 1:18
 * @homepage : https://github.com/sangji11
 */
public class SpecificViewModel extends BaseViewModel {

    Data<String> stroy = new Data<>();
    Data<String> name = new Data<>();

    public Data<String> getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director.setValue(director);
    }

    Data<String> director = new Data<>();

    public Data<String> getStroy() {
        return stroy;
    }

    public Data<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setStroy(String stroy) {
        this.stroy.setValue(stroy);
    }
}
