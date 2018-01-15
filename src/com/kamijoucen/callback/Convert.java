package com.kamijoucen.callback;

public interface Convert<O, V> {

    V convert(O o);
}
