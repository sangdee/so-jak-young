package com.cbnu.sjy_.core.logic;

import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.base.logic.BaseLogic;
import com.cbnu.sjy_.core.controller.LoginController;
import com.cbnu.sjy_.core.model.entity.UserEntity;
import com.cbnu.sjy_.util.Firebase;
import com.cbnu.sjy_.util.StringChecker;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class SignUpLogic extends BaseLogic {

    public SignUpLogic(BaseController owner) {
        super(owner);
    }

    private void insertDatabase(Task<AuthResult> task, UserEntity user) {
        if (task.isSuccessful()) {
            Firebase.reference("user")
                    .child(Firebase.uid())
                    .access(UserEntity.class)
                    .insert(user);
        }
    }

    private void updateView(Task<AuthResult> task) {
        hideProgress();
        if (task.isSuccessful()) {
            toast("회원가입에 성공했습니다.");
            moveAndFinish(LoginController.class);
        } else {
            toast("회원가입에 실패했습니다.");
        }
    }

    public void signUp(UserEntity user) {
        String id = user.getId();
        String pw = user.getPw();
        String name = user.getName();
        showProgress();

        if (StringChecker.isEmpty(id))
            hideAndToast("이이디를 입력해주세요");
        else if (StringChecker.isEmpty(pw))
            hideAndToast("비밀번호를 입력해주세요");
        else if (StringChecker.isShort(pw, 6))
            hideAndToast("비밀번호는 최소 6자 이상입니다");
        else if (StringChecker.isEmpty(name))
            hideAndToast("이름을 입력해주세요");

        else Firebase.auth()
                    .createUserWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(task -> {
                        insertDatabase(task, user);// 1. Insert Database
                        updateView(task); // 2. Update View
                    });
    }
}
