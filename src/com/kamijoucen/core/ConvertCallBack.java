package com.kamijoucen.core;

public interface ConvertCallBack<O, V> {

    V convert(O o);
}
