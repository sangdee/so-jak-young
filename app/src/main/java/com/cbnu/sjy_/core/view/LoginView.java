package com.cbnu.sjy_.core.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.NoCopySpan;
import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.BaseAcitivity;

/**
 * @author : Sangji Lee
 * @when : 2019-11-08 오전 12:35
 * @homepage : https://github.com/sangji11
 */
public class LoginView extends BaseAcitivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
    }
}
