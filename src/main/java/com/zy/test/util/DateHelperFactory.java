package com.zy.test.util;

public class DateHelperFactory {
    private static DateHelper instance = null;

    private DateHelperFactory() {
    }

    public static DateHelper get() {
        if (instance == null) {
            instance = new DateHelperImpl();
        }
        return instance;
    }

    public static void set(DateHelper newInstance) {
        instance = newInstance;
    }
}
