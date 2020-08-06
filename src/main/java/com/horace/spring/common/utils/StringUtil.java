package com.horace.spring.common.utils;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNotNullOrEmpty(String s) {
        return s != null && s.length() > 0;
    }
}
