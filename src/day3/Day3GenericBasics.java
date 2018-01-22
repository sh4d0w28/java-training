package day3;

import day2.assets.Child;
import day2.assets.Parent;

class TikiMath<T extends Integer, AT extends Object> { // Integer or any child is fine , for AT - multiple params
    public T add(T x, T y)
    {
        int a = x;
        int b = y;
        Integer temp = a+b;
        return (T)temp;
    }
}

public class Day3GenericBasics {

    public static <T extends Parent, U> T something(T param1, U params2) {  // GENERIC FUNCTION!!!!!!
        if (params2 != null) {
            return param1;
        }
        return param1;
    }

    public static void main(String[] args) {

        TikiMath<Integer, Object> intAddres = new TikiMath<>(); // Generics CANNOT BE PRIMITIVES!
        System.out.println(intAddres.add(2,3));

        something(new Child(), null);

    }

}
