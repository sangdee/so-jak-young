package com.cbnu.sjy_.core.viewmodel;

import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.util.Data;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오전 1:28
 * @homepage : https://github.com/sangji11
 */
public class ReservationViewModel extends BaseViewModel {
    private Data<String> name = new Data<>();

    public Data<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }
}
