package com.cbnu.sjy_.core.logic;

import android.os.Handler;

import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.base.logic.BaseLogic;
import com.cbnu.sjy_.core.controller.LoginController;
import com.cbnu.sjy_.core.controller.MainController;
import com.cbnu.sjy_.core.model.cache.UserCache;
import com.cbnu.sjy_.core.model.entity.User;
import com.cbnu.sjy_.util.Firebase;
import com.cbnu.sjy_.util.StringChecker;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class SplashLogic extends BaseLogic {

    public SplashLogic(BaseController owner) {
        super(owner);
    }

    private void moveScreen() {
        new Handler().postDelayed(() ->
                moveAndFinish(LoginController.class), 2500);
    }

    private void updateView(Task<AuthResult> task) {
        hideProgress();
        if (task.isSuccessful()) {
            moveAndFinish(MainController.class);
        } else {
            toast("로그인에 실패했습니다.");
        }
    }

    private void processAutonomousSignIn() {
        Firebase.reference("user")
                .child(Firebase.uid())
                .access(User.class)
                .select(u -> {
                    UserCache.getInstance().copy(u); // copy to cache
                    Firebase.auth() // autonomous signed in
                            .signInWithEmailAndPassword(u.getId(), u.getPw())
                            .addOnCompleteListener(this::updateView);
                });
    }

    public void splash() {
        String remembered = preference().getString("id");

        if (StringChecker.isEmpty(remembered)) moveScreen();
        else processAutonomousSignIn();
    }
}
