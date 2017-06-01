package com.zy.test.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RemoteIpHelper {
//单例模式
    private static RemoteIpHelper instance = null;

    public static RemoteIpHelper getInstance () {
        if (instance == null) {
            instance = new RemoteIpHelper();
        }
        return instance;
    }

    public static void setInstance(RemoteIpHelper newInstance) {
        instance = newInstance;
    }

    public String getRemoteAddr() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
    }
}