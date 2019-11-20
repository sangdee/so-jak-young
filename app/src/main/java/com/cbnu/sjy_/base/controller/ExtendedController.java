package com.cbnu.sjy_.base.controller;

import android.app.Activity;
import android.content.Intent;

import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.viwemodel.BaseViewModel;
import com.cbnu.sjy_.util.Preference;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public abstract class ExtendedController<V extends ViewDataBinding, VM extends BaseViewModel> extends MVVMController<V, VM> {

    public void requestPermissions(String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, 1);
    }

    public Preference preference() {
        return Preference.getInstance(this);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    public void startActivityAndFinish(Class<? extends Activity> activity) {
        startActivity(activity);
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }
}
