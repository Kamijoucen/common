package com.kamijoucen.common.callback;

public interface Convert<O, V> {

    V convert(O o);
}
