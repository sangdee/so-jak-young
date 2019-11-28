package com.cbnu.sjy_.core.viewmodel;

import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.util.Data;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class MainViewModel extends BaseViewModel {

    private Data<String> name = new Data<>();
    private Data<String> image = new Data<>();

    public Data<String> getImage() {
        return image;
    }

    public void setImage(Data<String> image) {
        this.image = image;
    }

    public void setName(Data<String> name) {
        this.name = name;
    }

    public Data<String> getName() {
        return name;
    }
}
