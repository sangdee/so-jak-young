package com.cbnu.sjy_.base.logic;

import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.util.Preference;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public abstract class NavigatorLogic {

    protected Navigator navigator;
    // there are no activity context

    public NavigatorLogic(BaseController owner) {
        this.navigator = new Navigator() {
            @Override public void move(Class<? extends BaseController> activity) {
                owner.startActivity(activity);
            }

            @Override public void finish() {
                owner.finish();
            }

            @Override public void moveAndFinish(Class<? extends BaseController> activity) {
                owner.startActivityAndFinish(activity);
            }

            @Override public void requestPermissions(String... permissions) {
                owner.requestPermissions(permissions);
            }

            @Override public Preference preference() {
                return owner.preference();
            }

            @Override public void toast(String msg) {
                owner.toast(msg);
            }

            @Override public void dialog(String title, String msg, Runnable action) {
                owner.dialog(title, msg, action);
            }

            @Override public void showProgress() {
                owner.showProgress();
            }

            @Override public void hideProgress() {
                owner.hideProgress();
            }

            @Override public void hideAndToast(String msg) {
                owner.hideAndToast(msg);
            }
        };
    }
}
