package com.cbnu.sjy_.core.model.cache;

import com.cbnu.sjy_.base.model.BaseCache;
import com.cbnu.sjy_.core.model.entity.UserEntity;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class UserCache extends BaseCache<UserEntity> {

    public static UserCache getInstance() {
        return LazyHolder.instance;
    }

    static class LazyHolder {
        static UserCache instance = new UserCache();
    }
}
