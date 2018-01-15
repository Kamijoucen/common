package com.kamijoucen.callback;

public interface Query<T> {
    boolean query(T t);
}
