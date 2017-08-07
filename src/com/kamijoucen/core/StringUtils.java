package com.kamijoucen.core;

import java.util.Collection;
import java.util.Iterator;

public class StringUtils {

    /**
     * 字符串是否全是字母
     * @param str
     * @return
     */
    public static boolean isAlpha(String str) {
        // TODO: 2017/8/8
        return true;
    }

    /**
     * str是否是空白符
     * @param str
     * @return
     */
    public static boolean isSpace(String str) {
        return str.trim() == "";
    }

    /**
     * 判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isDigit(String str) {
        int len = str.length();
        boolean flag = true;
        for (; --len >= 0 && flag; ) {
            char ch = str.charAt(len);
            flag = Character.isDigit(ch);
        }
        return flag;
    }

    /**
     * 使用分隔符连接字符串
     *
     * @param separate
     * @param strs
     * @return
     */
    public static String joinSepString(String separate, Object... strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        separate = separate == null ? "" : separate;
        StringBuilder builder = new StringBuilder();
        int loopSize = strs.length - 1;
        for (int i = 0; i < loopSize; i++) {
            builder.append(strs[i]).append(separate);
        }
        builder.append(strs[loopSize]);
        return builder.toString();
    }

    /**
     * 使用分隔符连接字符串
     *
     * @param separate
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> String joinSepString(String separate, Collection<T> collection) {
        if (collection == null || collection.size() == 0) {
            return "";
        }
        separate = Utils.blankDefVal(separate, "");
        StringBuilder builder = new StringBuilder();
        int loopSize = collection.size() - 1;
        Iterator<T> iter = collection.iterator();
        for (int i = 0; i < loopSize; i++) {
            T obj = iter.next();
            builder.append(obj).append(separate);
        }
        T obj = iter.next();
        builder.append(obj);
        return builder.toString();
    }


    /**
     * 连接字符串
     *
     * @param strs
     * @return
     */
    public static String joinString(String... strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

}
