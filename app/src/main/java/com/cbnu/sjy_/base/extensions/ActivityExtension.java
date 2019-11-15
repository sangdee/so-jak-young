package com.cbnu.sjy_.base.extensions;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.cbnu.sjy_.R;

/**
 * 액티비티의 기본 기능을 추상화 하기 위한 Activity Hierarchy
 * 이동 후 액티비티 종료 (startActivityAndFinish)와 같이 여러번 호출해야하는 메소드를
 * 편리하게 한번에 사용하기 위해 구현함
 */
public abstract class ActivityExtension extends AppCompatActivity {

    protected void getPermission(String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, 1);
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
}
