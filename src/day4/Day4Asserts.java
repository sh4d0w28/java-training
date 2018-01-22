package day4;

public class Day4Asserts {

    public static String doSomething() {
        return "WOW!";
    }

    public static void main(String[] args) {

        int x = 5;

        assert x > 10 : doSomething();   // functions MUST RETURN SOMETHING!
    }
}
