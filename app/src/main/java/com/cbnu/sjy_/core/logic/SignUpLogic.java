package com.cbnu.sjy_.core.logic;

import com.cbnu.sjy_.base.BaseLogic;
import com.cbnu.sjy_.core.controller.LoginController;
import com.cbnu.sjy_.core.model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * @author : Sangji Lee
 * @when : 2019-11-15 오후 10:50
 * @homepage : https://github.com/sangji11
 */
public class SignUpLogic extends BaseLogic {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    protected SignUpLogic(ServiceBuilder builder) {
        super(builder);
    }

    private boolean isEmpty(String str) {
        return str == null || str.replaceAll(" ", "").equals("");
    }

    private void updateView(Task<AuthResult> task) {
        if (task.isSuccessful()) {
            moveAndFinish.move(LoginController.class);
        } else {
            toast.show("회원가입에 실패했습니다.");
        }
    }

    public void sign(User user) {
        String id = user.getId();
        String pw = user.getPw();
        String name = user.getName();

        if (isEmpty(id)) toast.show("이이디를 입력해주세요");
        else if (isEmpty(pw)) toast.show("비밀번호를 입력해주세요");
        else if (isEmpty(name)) toast.show("이름을 입력해주세요");
        else auth.createUserWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(this::updateView);

    }

}
