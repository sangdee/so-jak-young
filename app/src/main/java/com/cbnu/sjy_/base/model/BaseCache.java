package com.cbnu.sjy_.base.model;


/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */

public abstract class BaseCache<E extends BaseEntity> {
    protected E data;

    public E read() {
        return data;
    }

    public void copy(E data) {
        this.data = data;
    }
}