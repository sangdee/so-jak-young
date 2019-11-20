package com.cbnu.sjy_.base.logic;

import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.util.Preference;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public interface Navigator {
    void move(Class<? extends BaseController> activity);

    void finish();

    void moveAndFinish(Class<? extends BaseController> activity);

    void requestPermissions(String... permissions);

    Preference preference();

    void toast(String msg);

    void dialog(String title, String msg, Runnable action);

    void showProgress();

    void hideProgress();

    void hideAndToast(String msg);
}
