package com.cbnu.sjy_.util;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
public class StringChecker {

    public static boolean isEmpty(String str) {
        return str == null || str.replaceAll(" ", "").equals("");
    }

    public static boolean isShort(String str, int min) {
        return str.length() < min;
    }
}
