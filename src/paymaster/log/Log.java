package paymaster.log;

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

    public static void printlnGood(String s) { System.out.println(wrapGood(s)); }

    public static void printlnError(String s) { System.out.println(wrapError(s)); }

    public static void printPromt(String s) { System.out.print(wrapPromt(s));}
}
