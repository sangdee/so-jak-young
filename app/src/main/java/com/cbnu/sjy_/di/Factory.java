package com.cbnu.sjy_.di;

import com.cbnu.sjy_.base.controller.BaseController;
import com.cbnu.sjy_.base.logic.BaseLogic;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class Factory {

    public static <T extends BaseLogic> T createTask(BaseController owner, Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor(BaseController.class)
                    .newInstance(owner);

        } catch (NoSuchMethodException | InstantiationException |
                IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
