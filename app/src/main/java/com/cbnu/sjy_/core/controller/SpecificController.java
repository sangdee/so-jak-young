package com.cbnu.sjy_.core.controller;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.core.viewmodel.SpecificViewModel;
import com.cbnu.sjy_.databinding.SpecificView;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오전 12:31
 * @homepage : https://github.com/sangji11
 */

public class SpecificController extends BaseController<SpecificView, SpecificViewModel> {
    @Override
    protected int injectView() {
        return R.layout.view_spec;
    }
}
