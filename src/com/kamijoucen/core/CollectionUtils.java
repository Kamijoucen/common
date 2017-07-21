package com.kamijoucen.core;

import java.util.*;

public class CollectionUtils {

    /**
     * 获取一个只读的空list
     *
     * @param <T>
     * @return
     */
    public static <T> List<T> readOnlyList() {
        return Collections.emptyList();
    }

    /**
     * 使用K, V生成map对象
     *
     * @param kvs
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> map(Object... kvs) {
        Map<K, V> map = map();
        int len = kvs.length;
        for (int i = 0; i < len && (i + 1) < len; i += 2) {
            K key = (K) kvs[i];
            V val = (V) kvs[i + 1];
            map.put(key, val);
        }
        return map;
    }

    /**
     * 新建一个hashMap实例
     *
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    /**
     * 新建一个 arrayList 实例
     *
     * @param <T>
     * @return
     */
    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    /**
     * 用给定的参数列表创建一个list
     *
     * @param objs
     * @param <T>
     * @return
     */
    public static <T> List<T> list(T... objs) {
        List<T> list = list();
        list.addAll(Arrays.asList(objs));
        return list;
    }

    /**
     * 删除集合最后一个元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T removeLastObj(List<T> list) {
        int size = list.size();
        if (size == 0) {
            return null;
        }
        return list.remove(size - 1);
    }

    /**
     * 获取集合最后一个元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getLastObj(List<T> list) {
        int size = list.size();
        if (size == 0) {
            return null;
        }
        return list.get(size - 1);
    }

    /**
     * 判断数组是否为空
     *
     * @param objs
     * @return
     */
    public static boolean isEmptyArray(Object[] objs) {
        return objs == null || objs.length == 0;
    }


    /**
     * 判断集合是否为空
     *
     * @param collection
     * @return 为空则返回 true
     */
    public static boolean isEmptyCollection(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 返回集合的第一个元素
     *
     * @param con
     * @param <T>
     * @return
     */
    public static <T> T firstObj(Collection<T> con) {
        if (isEmptyCollection(con)) {
            return null;
        }
        return con.iterator().next();
    }

    /**
     * 返回数组的第一个元素
     *
     * @param con
     * @param <T>
     * @return
     */
    public static <T> T firstObj(T[] con) {
        if (con == null || con.length == 0) {
            return null;
        }
        return con[0];
    }

}
