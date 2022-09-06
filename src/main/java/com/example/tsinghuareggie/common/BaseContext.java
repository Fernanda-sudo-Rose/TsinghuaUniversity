package com.example.tsinghuareggie.common;

/**
 * 基于ThreadLocal封装的工具类，用户保存和获取当前登录用户的id
 */
public class BaseContext {

    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 设置值
     * @param id
     */
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    /**
     * 设置值
     * @return
     */
    public static Long getCurrentId() {
        return threadLocal.get();

    }

}
