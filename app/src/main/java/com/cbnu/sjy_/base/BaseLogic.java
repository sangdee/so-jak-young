package com.cbnu.sjy_.base;

import java.lang.reflect.InvocationTargetException;

import java8.lang.FunctionalInterface;

public abstract class BaseLogic {

    protected ToastNavigator toast;
    protected DialogNavigator dialog;
    protected MoveNavigator move;
    protected MoveNavigator moveAndFinish;
    protected FinishNavigator finish;

    protected BaseLogic(ServiceBuilder builder) {
        this.toast = builder.toast;
        this.dialog = builder.dialog;
        this.move = builder.move;
        this.moveAndFinish = builder.moveAndFinish;
        this.finish = builder.finish;
    }

    public static ServiceBuilder builder() {
        return new ServiceBuilder();
    }

    public static class ServiceBuilder {

        private ToastNavigator toast;
        private DialogNavigator dialog;
        private MoveNavigator move;
        private MoveNavigator moveAndFinish;
        private FinishNavigator finish;

        public ServiceBuilder setToast(ToastNavigator toast) {
            this.toast = toast;
            return this;
        }

        public ServiceBuilder setDialog(DialogNavigator dialog) {
            this.dialog = dialog;
            return this;
        }

        public ServiceBuilder setMove(MoveNavigator move) {
            this.move = move;
            return this;
        }

        public ServiceBuilder setMoveAndFinish(MoveNavigator moveAndFinish) {
            this.moveAndFinish = moveAndFinish;
            return this;
        }

        public ServiceBuilder setFinish(FinishNavigator finish) {
            this.finish = finish;
            return this;
        }

        public <S extends BaseLogic> S build(Class<S> clazz)
                throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            return clazz.getDeclaredConstructor(ServiceBuilder.class).newInstance(this);
        }
    }

    @FunctionalInterface
    public interface ToastNavigator {
        void show(String msg);
    }

    @FunctionalInterface
    public interface DialogNavigator {
        void show(String title, String msg, Runnable action, boolean cancelable);
    }

    @FunctionalInterface
    public interface MoveNavigator {
        void move(Class<? extends BaseController> clazz);
    }

    @FunctionalInterface
    public interface FinishNavigator {
        void finish();
    }
}
