package com.kamijoucen.core;

import java.util.*;

public final class Utils {

    /**
     * 判断对象是否与列表中任意一个对象相等
     *
     * @param obj
     * @param objs
     * @return
     */
    public static boolean orEquals(Object obj, Object... objs) {
        if (obj == null || CollectionUtils.isEmptyArray(objs)) {
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
    public static boolean isNotBlank(Object t) {
        return !isBlankVal(t);
    }

    /**
     * 如果 obj 为空则返回默认值， 否则返回 defval
     *
     * @param obj
     * @param defVal
     * @param <T>
     * @return
     */
    public static <T> T blankDefVal(T obj, T defVal) {
        return isBlankVal(obj) ? defVal : obj;
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
    public static boolean isAndBlank(Object... objs) {
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
    public static boolean isAndNotBlank(Object... objs) {
        boolean isNotNull = true;
        for (Object o : objs) {
            isNotNull = isNotNull && isNotBlank(o);
        }
        return isNotNull;
    }

    /**
     * 是否有任意一个元素为空
     *
     * @param objs
     * @return
     */
    public static boolean isOrBlank(Object... objs) {
        boolean isNull = false;
        for (Object o : objs) {
            isNull = isNull || isBlankVal(o);
        }
        return isNull;
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
     *
     * @param key
     * @param lists
     * @param <T>
     * @return
     */
    public static <T extends Object> boolean equalsOrList(T key, List<T> lists) {
        boolean flag = true;
        for (int i = 0; i < lists.size() && flag; ++i) {
            if (key.equals(lists.get(i))) {
                flag = false;
            }
        }
        return !flag;
    }

}