package com.kamijoucen.common.utils;

import java.security.MessageDigest;
import java.util.*;

public final class Utils {

    /**
     * 类型转换
     * @param o
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T cast(Object o, Class<T> c) {
        return (T) o;
    }

    /**
     * 转换类型 （根据返回值推导泛型<T>的类型，仅在JDK1.8+有效）
     * @param o
     * @param <T>
     * @return
     */
    public static <T> T cast(Object o) {
        return (T) o;
    }

    /**
     * 判断对象是否为空
     * isBlank(null) == true
     * isBlank("lisicen") == false
     * isBlank("") == true
     *
     * @param t
     * @return
     */
    public static boolean isBlankVal(Object t) {
        return t == null || (t instanceof String && ((String) t).trim().equals(""));
    }

    /**
     * 判断对象是否为不为空
     * isBlank(null) == false
     * isBlank("lisicen") == true
     * isBlank("") == false
     *
     * @param t
     * @return
     */
    public static boolean isNotBlankVal(Object t) {
        return !isBlankVal(t);
    }

    /**
     * 如果 obj 为空则返回默认值， 否则返回 defval
     * (空串也为空)
     * @param obj
     * @param defVal
     * @param <T>
     * @return
     */
    public static <T> T blankDefVal(T obj, T defVal) {
        return isBlankVal(obj) ? defVal : obj;
    }

    /**
     * 如果 obj 为空则返回默认值， 否则返回 defval
     * @param obj
     * @param defVal
     * @param <T>
     * @return
     */
    public static <T> T nullDefVal(T obj, T defVal) {
        return obj == null ? defVal : obj;
    }

    /**
     * 判断对象是否全部为空
     * isAndBlank(null, "lisice", true) == false;
     * isAndBlank(null, "", "") == true;
     * isAndBlank(null, false, null) == false;
     *
     * @param objs
     * @return
     */
    public static boolean isAndBlankVal(Object... objs) {
        if (CollecUtils.isEmptyArray(objs)) {
            return true;
        }
        boolean isNull = true;
        for (Object o : objs) {
            isNull = isNull && isBlankVal(o);
        }
        return isNull;
    }

    /**
     * 是否全部不为空
     *
     * @param objs
     * @return
     */
    public static boolean isAndNotBlankVal(Object... objs) {
        if (CollecUtils.isEmptyArray(objs)) {
            return false;
        }
        for (Object o : objs) {
            if (isBlankVal(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否有任意一个元素为空
     *
     * @param objs
     * @return
     */
    public static boolean isOrBlankVal(Object... objs) {
        if (CollecUtils.isEmptyArray(objs)) {
            return true;
        }
        boolean isAnyNull = false;
        for (int i = 0; i < objs.length && !isAnyNull; ++i) {
            isAnyNull = isBlankVal(objs[i]);
        }
        return isAnyNull;
    }

    /**
     * 是否有任意一个元素不为空
     * @param objs
     * @return
     */
    public static boolean isOrNotBlankVal(Object... objs) {
        if (CollecUtils.isEmptyArray(objs)) {
            return false;
        }
        boolean isBlank = true;

        for (int i = 0; i < objs.length && isBlank; ++i) {
            isBlank = isBlankVal(objs[i]);
        }
        return !isBlank;
    }

    /**
     * 随机生成UUID
     *
     * @return UUID
     */
    public static String UUID() {
        return UUID.randomUUID().toString();
    }


    /**
     * 得到一个  0 - i 的随机数
     *
     * @param i 随机数上限， 不包括
     * @return 随机数
     */
    public static int random(int i) {
        return (int) (Math.random() * i);
    }


    /**
     * 只要lists中任意一个value与key相同返回真
     * null与任何比较都为false
     *
     * @param key
     * @param lists
     * @param <T>
     * @return
     */
    public static <T extends Object> boolean equalsOrList(T key, List<T> lists) {
        if (key == null || CollecUtils.isEmptyCollection(lists)) {
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < lists.size() && flag; ++i) {
            if (key.equals(lists.get(i))) {
                flag = false;
            }
        }
        return !flag;
    }

    /**
     * 判断对象是否与列表中任意一个对象相等
     *
     * @param obj
     * @param objs
     * @return
     */
    public static boolean orEquals(Object obj, Object... objs) {
        if (obj == null || CollecUtils.isEmptyArray(objs)) {
            return false;
        }
        boolean success = false;
        int len = objs.length;
        for (int i = 0; i < len && !success; i++) {
            success = obj.equals(objs[i]);
        }
        return success;
    }


    /**
     * 生成字符串的MD5
     * @param s
     * @return
     */
    public static String MD5(String s) {
        if (isBlankVal(s)) {
            return null;
        }
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        byte[] btInput = s.getBytes();
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}