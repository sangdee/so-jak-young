package com.cbnu.sjy_.core.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.BaseAcitivity;
import com.cbnu.sjy_.core.view.fragmentView.FragmentB;
import com.cbnu.sjy_.core.view.fragmentView.FragmentC;

/**
 * @author : Sangji Lee
 * @when : 2019-11-11 오전 11:46
 * @homepage : https://github.com/sangji11
 */
public class MainView extends BaseAcitivity {
    private boolean isFragmentB = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main);
        Button swithBtn = findViewById(R.id.button1);
        swithBtn.setOnClickListener((v) -> {
            switchFragment();
        });
    }

    public void switchFragment() {
        Fragment fr;
        if (isFragmentB) {
            fr = new FragmentB();
        } else {
            fr = new FragmentC();
        }
        isFragmentB = (isFragmentB) ? false : true;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBorC, fr);
        fragmentTransaction.commit();

    }
}
