package com.lazada.assets;

public class Log {

    public static String wrapGood(String s) {
        return "[OK ]: " + s;
    }

    public static String wrapError(String s) {
        return "[ERR]: " + s;
    }

    public static String wrapTitle(String s) {
        return "\n[" + s + "]";
    }

    public static String wrapPromt(String s) {
        return s + " /> ";
    }
}
