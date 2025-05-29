package com.pluralsight.program;

import java.io.IOException;
import java.text.ParseException;

public interface MenuReturnType<T> {
    T get() throws IOException, InterruptedException, ParseException;
}
