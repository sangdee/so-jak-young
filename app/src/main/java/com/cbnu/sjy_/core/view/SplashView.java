package com.cbnu.sjy_.core.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.BaseAcitivity;

public class SplashView extends BaseAcitivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_splash);
        splash();
         }
         private void splash(){
        getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivityAndFinish(LoginView.class);
            }

        },2000);
         }
}
