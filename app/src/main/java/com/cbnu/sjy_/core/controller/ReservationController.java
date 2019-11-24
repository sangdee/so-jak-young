package com.cbnu.sjy_.core.controller;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.viewmodel.ReservationViewModel;
import com.cbnu.sjy_.databinding.ReservationView;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오전 1:27
 * @homepage : https://github.com/sangji11
 */
public class ReservationController extends BaseController<ReservationView, ReservationViewModel> {
    @Override
    protected int injectView() {
        return R.layout.view_reservation;
    }

}

