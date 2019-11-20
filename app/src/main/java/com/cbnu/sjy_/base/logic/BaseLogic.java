package com.cbnu.sjy_.base.logic;

import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.util.Preference;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public abstract class BaseLogic extends NavigatorLogic implements Navigator {

    public BaseLogic(BaseController owner) {
        super(owner);
    }

    public void move(Class<? extends BaseController> activity) {
        navigator.move(activity);
    }

    public void moveAndFinish(Class<? extends BaseController> activity) {
        navigator.moveAndFinish(activity);
    }

    public void finish() {
        navigator.finish();
    }

    public void requestPermissions(String... permissions) {
        navigator.requestPermissions(permissions);
    }

    public Preference preference() {
        return navigator.preference();
    }

    public void toast(String msg) {
        navigator.toast(msg);
    }

    public void dialog(String title, String msg, Runnable action) {
        navigator.dialog(title, msg, action);
    }

    public void showProgress() {
        navigator.showProgress();
    }

    public void hideProgress() {
        navigator.hideProgress();
    }

    public void hideAndToast(String msg) {
        navigator.hideAndToast(msg);
    }
}
