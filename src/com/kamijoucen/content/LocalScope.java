package com.kamijoucen.content;

import com.kamijoucen.core.CollectionUtils;

import java.util.Map;

/**
 * 对一个线程可见的Map
 */
public class LocalScope {

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void put(String key, Object val) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = CollectionUtils.map();
            threadLocal.set(map);
        }
        map.put(key, val);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            return null;
        }
        return map.get(key);
    }
}