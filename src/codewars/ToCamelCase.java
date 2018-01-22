package codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToCamelCase {

    static String toCamelCase(String s){

        Matcher m = Pattern.compile("_[a-z]").matcher(s);
        return "";
    }

    public static void main(String[] args) {
        String s = "the_Stealth_Warrior";
        System.out.println(toCamelCase(s));
    }
}
