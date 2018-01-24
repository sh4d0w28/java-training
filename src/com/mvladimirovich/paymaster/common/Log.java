package com.mvladimirovich.paymaster.common;

public class Log {

    private static String goodStr = "[OK ]: ";
    private static String errorStr = "[ERR]: ";

    private static String wrapGood(String s) {
        return goodStr + s;
    }

    private static String wrapError(String s) {
        return errorStr + s;
    }

    public static void printlnGood(String s) { System.out.println(wrapGood(s)); }

    public static void printlnError(String s) { System.out.println(wrapError(s)); }

    public static void printFormatGood(String s, Object... vars) {
        System.out.print(Log.wrapGood(String.format(s, vars)));
    }
}
