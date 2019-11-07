package com.cbnu.sjy_.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import com.cbnu.sjy_.R;

/**
 * @author : Sangji Lee
 * @when : 2019-11-08 오전 12:36
 * @homepage : https://github.com/sangji11
 */
public abstract class BaseAcitivity extends AppCompatActivity {

    private Handler handler = new Handler();

    protected void getPermission(String... permisions) {
        ActivityCompat.requestPermissions(this, permisions, 1);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    public void startActivityAndFinish(Class<? extends Activity> activity) {
        startActivity(activity);
        finish();
    }

    public Handler getHandler() {
        return handler;
    }
}
