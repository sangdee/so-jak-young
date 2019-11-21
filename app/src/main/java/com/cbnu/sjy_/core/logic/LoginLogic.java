package com.cbnu.sjy_.core.logic;

import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.base.logic.BaseLogic;
import com.cbnu.sjy_.core.controller.MainController;
import com.cbnu.sjy_.core.model.cache.UserCache;
import com.cbnu.sjy_.core.model.entity.User;
import com.cbnu.sjy_.util.Data;
import com.cbnu.sjy_.util.Firebase;
import com.cbnu.sjy_.util.StringChecker;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class LoginLogic extends BaseLogic {

    public LoginLogic(BaseController owner) {
        super(owner);
    }

    private void staySignedIn(Task<AuthResult> task, User user, Data<Boolean> stay) {
        if (task.isSuccessful()) {
            if (stay.getValue()) {
                preference().setString("id", user.getId());
                preference().setString("pw", user.getPw());
            } else {
                preference().setString("id", null);
                preference().setString("pw", null);
            }
        }
    }

    private void addEntityToCache(Task<AuthResult> task) {
        Firebase.reference("user")
                .child(Firebase.uid())
                .access(User.class)
                .select(u -> {
                    UserCache.getInstance().copy(u);
                    updateView(task); // 3. Update View
                });
    }

    private void updateView(Task<AuthResult> task) {
        hideProgress();
        if (task.isSuccessful()) {
            moveAndFinish(MainController.class);
        } else {
            toast("로그인에 실패했습니다.");
        }
    }

    public void signIn(User user, Data<Boolean> stay) {
        String id = user.getId();
        String pw = user.getPw();
        showProgress();
        if (StringChecker.isEmpty(id))
            hideAndToast("아이디를 입력해주세요");
        else if (StringChecker.isEmpty(pw))
            hideAndToast("비밀번호를 입력해주세요");
        else Firebase.auth()
                    .signInWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(task -> {
                        staySignedIn(task, user, stay); // 1. Stay Processing
                        addEntityToCache(task); // 2. Add Entity To Cache

                    });
    }
}
