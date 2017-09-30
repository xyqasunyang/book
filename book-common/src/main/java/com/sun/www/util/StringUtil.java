package com.sun.www.util;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月29日
 */
public class StringUtil {
    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
}
