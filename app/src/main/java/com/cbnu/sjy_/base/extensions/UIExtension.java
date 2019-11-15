package com.cbnu.sjy_.base.extensions;

import android.app.AlertDialog;
import android.widget.Toast;

/**
 * 프레젠테이션 로직을 구현하는 Activity Hierarchy
 * 안드로이드에서는 프레젠테이션 로직 (화면 표시 로직 등)을 반드시 액티비티에서 구현해야함
 * 프레젠테이션 로직을 사용하기 위해서는 Context가 필요함.
 * 안드로이드에서 Context는 휴대폰 단말 정보, 해당 화면(액티비티)의 정보 등이 담기는데 액티비티의 주민등록증이라고 생각하면 편함.
 * Context는 Activity Level의 Context와 Application Level의 Context로 나뉨.
 * Activity Level Context는 해당 액티비티가 존재할때까지만 유효하며, 액티비티 종료후 제거되지만,
 * Application Level Context는 앱이 종료되기 전까지 유효함. 이 둘은 역할이 다른데,
 * 일례로 Toast 호출에는 두 Context 모두 사용 가능하지만, Dailog 호출에는 Activity Level Context만 사용 가능함
 * 액티비티에서 getApplicationContext() 메소드를 호출하면 Application Level의 Context도 얻을 수 있음
 */
public abstract class UIExtension extends ActivityExtension {


    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    public void dialog(String title, String msg, Runnable positive, boolean cancelable) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("확인", (dialog, which) -> positive.run())
                .setNegativeButton("취소", (dialog, which) -> {
                })
                .setCancelable(cancelable)
                .create()
                .show();
    }

}
