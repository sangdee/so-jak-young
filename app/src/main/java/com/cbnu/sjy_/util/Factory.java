package com.cbnu.sjy_.util;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;

import com.cbnu.sjy_.base.BaseController;
import com.cbnu.sjy_.base.BaseLogic;

import java.lang.reflect.InvocationTargetException;

public class Factory {
    // 리플렉션 팩토리

    public static <M extends ViewModel> M createView(BaseController owner, Class<M> clazz) {
        return new ViewModelProvider(owner, new NewInstanceFactory()).get(clazz);
    }

    public static <S extends BaseLogic> S createService(BaseController owner, Class<S> clazz) {
        try {
            return BaseLogic.builder()
                    .setToast(owner::toast)
                    .setDialog(owner::dialog)
                    .setMove(owner::startActivity)
                    .setMoveAndFinish(owner::startActivityAndFinish)
                    .setFinish(owner::finish)
                    .build(clazz);

        } catch (NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException ignore) {
        }
        return null;
    }
}
