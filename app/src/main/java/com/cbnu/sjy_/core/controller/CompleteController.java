package com.cbnu.sjy_.core.controller;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.viewmodel.CompleteViewModel;
import com.cbnu.sjy_.databinding.CompleteView;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오후 3:35
 * @homepage : https://github.com/sangji11
 */
public class CompleteController extends BaseController<CompleteView, CompleteViewModel> {
    @Override
    protected int injectView() {
        return R.layout.view_complete;
    }

}
