package com.cbnu.sjy_.util;

import com.cbnu.sjy_.base.model.BaseCache;
import com.cbnu.sjy_.core.model.entity.Movie;
import com.cbnu.sjy_.core.model.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Sangji Lee
 * @when : 2019-11-22 오후 5:57
 * @homepage : https://github.com/sangji11
 */
public class Cache extends BaseCache {

    public static User userCache = new User();
    public static List<Movie> movieCache = new ArrayList<>();

}
