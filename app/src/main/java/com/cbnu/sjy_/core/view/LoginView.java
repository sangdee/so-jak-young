package com.cbnu.sjy_.core.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cbnu.sjy_.R;
import com.cbnu.sjy_.base.BaseAcitivity;
import com.cbnu.sjy_.util.TypeWriter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * @author : Sangji Lee
 * @when : 2019-11-08 오전 12:35
 * @homepage : https://github.com/sangji11
 */
public class LoginView extends BaseAcitivity {
    private EditText id;
    private EditText password;
    private CheckBox id_save;
    private View login;
    private View signup;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    String shared = "file";

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = id.getText().toString();
        editor.putString("idSave", value);
        editor.putBoolean("chk1", id_save.isChecked());


        editor.commit();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();
        id = findViewById(R.id.loginView_edittext_id);
        password = findViewById(R.id.loginView_edittext_password);
        login = findViewById(R.id.loginView_button_login);
        signup = findViewById(R.id.loginVeiw_button_signup);
        id_save = findViewById(R.id.id_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        Boolean chk1 = sharedPreferences.getBoolean("chk1", false);
        if (chk1 == true) {

            String value = sharedPreferences.getString("idSave", "");

            id_save.setChecked(chk1);
            id.setText(value);

        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                findViewById(R.id.progressBar).setVisibility(android.view.View.VISIBLE);
                loginEvent();
            }
        });
        signup.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivityAndFinish(SignUpView.class);
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //로그인
                    findViewById(R.id.progressBar).setVisibility(android.view.View.GONE);
                    startActivityAndFinish(MainView.class);
                } else {
                    //로그아웃
                }
            }
        };
        password.setOnKeyListener(new android.view.View.OnKeyListener() {
            @Override
            public boolean onKey(android.view.View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    login.performClick();
                    //Enter키눌렀을떄 처리
                    return true;
                }
                return false;
            }


        });
    }

    //로그인이 완료되면 성공했는지 확인
    void loginEvent() {
        if (id.getText() == null || id.getText().toString().replaceAll(" ", "").equals("")) {
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
            findViewById(R.id.progressBar).setVisibility(android.view.View.GONE);
        } else if (password.getText() == null || password.getText().toString().replaceAll(" ", "").equals("")) {
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            findViewById(R.id.progressBar).setVisibility(android.view.View.GONE);
        } else {
            firebaseAuth.signInWithEmailAndPassword(id.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                //로그인 실패한부분
                                Toast.makeText(LoginView.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                findViewById(R.id.progressBar).setVisibility(android.view.View.GONE);
                            }
                        }
                    });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TypeWriter typeWriter = findViewById(R.id.typeWriterView);
        typeWriter.write("소공 속 작은 영화관", 250);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }
}

