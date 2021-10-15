package com.wei.pims.util;

public class TextUtils {
    public static boolean isEmpty(String text) {
        if (text == null || "".equals(text.trim())) {
            return true;
        }
        return false;
    }
}
