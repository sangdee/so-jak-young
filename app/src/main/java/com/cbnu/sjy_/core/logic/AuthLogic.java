package com.cbnu.sjy_.core.logic;

import com.cbnu.sjy_.base.BaseLogic;
import com.cbnu.sjy_.core.controller.MainController;
import com.cbnu.sjy_.core.model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthLogic extends BaseLogic {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    protected AuthLogic(ServiceBuilder builder) {
        super(builder);
    }

    private boolean isEmpty(String str) {
        return str == null || str.replaceAll(" ", "").equals("");
    }

    private void updateView(Task<AuthResult> task) {
        if (task.isSuccessful()) {
            moveAndFinish.move(MainController.class);
        } else {
            toast.show("로그인에 실패했습니다.");
        }
    }

    public void login(User user) {
        String id = user.getId();
        String pw = user.getPw();

        if (isEmpty(id)) toast.show("이이디를 입력해주세요");
        else if (isEmpty(pw)) toast.show("비밀번호를 입력해주세요");
        else auth.signInWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(this::updateView);

    }
}
