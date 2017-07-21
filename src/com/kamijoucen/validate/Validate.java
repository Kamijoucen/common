package com.kamijoucen.validate;

import com.kamijoucen.core.Utils;

public class Validate {

    public static void notBlankVal(Object obj) {
        if (Utils.isBlankVal(obj)) {
            throw new NullPointerException("对象不能为空");
        }
    }

    public static void notBlankVal(Object obj, String info) {
        if (Utils.isBlankVal(obj)) {
            throw new NullPointerException(info);
        }
    }

    public static void notNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("对象不能为空");
        }
    }

    public static void notNull(Object obj, String info) {
        if (obj == null) {
            throw new NullPointerException(info);
        }
    }
}
