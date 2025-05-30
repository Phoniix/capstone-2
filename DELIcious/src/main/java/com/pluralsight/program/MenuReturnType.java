package com.pluralsight.program;

public interface MenuReturnType<T> {
    T get() throws InterruptedException;
}
