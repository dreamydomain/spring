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

    public static String[] splitByLength(String s, int length) {
        String[] returnStringArray = new String[s.length() / length + 1];
        for (int i = 0; i < s.length() / length + 1; i++) {
            int start = i * length;
            int end = (i + 1) * length;
            if (end > s.length()) {
                end = s.length();
            }
            String temp = s.substring(start, end);
            returnStringArray[i] = temp;
        }
        return returnStringArray;
    }

    public static void main(String[] args) {
        String s = "12345678901234567890123456789012345678901234567890asd";
        String[] ss = splitByLength(s, 10);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }
}
