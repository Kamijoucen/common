package com.kamijoucen.common.utils;

import com.kamijoucen.common.callback.Convert;
import com.kamijoucen.common.callback.Query;
import com.kamijoucen.common.validate.Validate;

import java.util.*;

public class CollecUtils {

    /**
     * 根据回调转换类型
     * @param coll
     * @param call
     * @param <O>
     * @param <V>
     * @return
     */
    public static <O, V> List<V> convertList(Collection<O> coll, Convert<O, V> call) {
        List<V> list = list();
        for (O o : coll) {
            list.add(call.convert(o));
        }
        return list;
    }

    /**
     * 根据查询规则从集合中查询符合规则的对象
     * @param coll
     * @param callBack
     * @param <T>
     * @return
     */
    public static <T> List<T> finds(Collection<T> coll, Query<T> callBack) {
        Validate.notNull(coll);
        Validate.notNull(callBack);
        List<T> list = list();
        Iterator<T> iter = coll.iterator();
        for (; iter.hasNext(); ) {
            T t = iter.next();
            if (callBack.query(t)) {
                list.add(t);
            }
        }
        return list;
    }

    /**
     * 根据查询规则从集合中查询第一个符合规则的对象
     * @param coll
     * @param callBack
     * @param <T>
     * @return
     */
    public static <T> T find(Collection<T> coll, Query<T> callBack) {
        Validate.notNull(coll);
        Validate.notNull(callBack);
        Iterator<T> iter = coll.iterator();
        for (; iter.hasNext(); ) {
            T t = iter.next();
            if (callBack.query(t)) {
                return t;
            }
        }
        return null;
    }

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
        if (objs == null) {
            return list;
        }
        for (T o : objs) {
            list.add(o);
        }
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
    public static <T> T lastObj(List<T> list) {
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

    /**
     * 返回列表第 i 个元素 (从 0 开始)
     * @param list
     * @param i
     * @param <T>
     * @return
     */
    public static <T> T get(List<T> list, int i) {
        if (i < 0 || isEmptyCollection(list)) {
            return null;
        }
        int size = list.size();
        if (i >= size) {
            return null;
        }
        return list.get(i);
    }


    /**
     * 返回列表第 i 个字符 (从 0 开始)
     * @param list
     * @param i
     * @return
     */
    public static String getString(List<String> list, int i) {
        if (i < 0 || isEmptyCollection(list)) {
            return "";
        }
        int size = list.size();
        if (i >= size) {
            return "";
        }
        String s = list.get(i);
        return s == null ? "" : s;
    }


    /**
     * 返回列表第 i 个元素 (从 0 开始)
     * @param arr
     * @param i
     * @param <T>
     * @return
     */
    public static <T> T get(T[] arr, int i) {
        if (i < 0 || isEmptyArray(arr)) {
            return null;
        }
        int size = arr.length;
        if (i >= size) {
            return null;
        }
        return arr[i];
    }

    /**
     * 返回列表第 i 个字符 (从 0 开始)
     * @param arr
     * @param i
     * @return
     */
    public static String getString(String[] arr, int i) {
        if (i < 0 || isEmptyArray(arr)) {
            return "";
        }
        int size = arr.length;
        if (i >= size) {
            return "";
        }
        String s = arr[i];
        return s == null ? "" : s;
    }


}
