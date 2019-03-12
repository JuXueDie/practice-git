package com.example.book.utils;

import java.util.HashSet;
import java.util.Set;

public class GlobalErrorCodes {

    private static Set<Integer> codecs = new HashSet<>();

    public synchronized static void addCodes(Integer code) {
        if (codecs.contains(code)) {
            throw new IllegalStateException("duplicated code: " + code);
        }
        codecs.add(code);
    }

}
