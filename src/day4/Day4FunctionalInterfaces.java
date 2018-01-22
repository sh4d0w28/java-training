package day4;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface IDemo<P, R> {  // BUILT-IN FUNCTIONAL INTERFACES IN """"SE8"""" ONLY

    R demoProcess(P param1, P param2);
}

public class Day4FunctionalInterfaces {

    public static void main(String args[]) {

        IDemo<String, Boolean> demoFx = (p1, p2)->{ // NO PRIMITIVES!!!
            return p1.equals(p2);
        };

        System.out.println(demoFx.demoProcess("TT", "QQ"));
        System.out.println(demoFx.demoProcess("TT", "TT"));

        Function<String,String> fx = (x)->{    // functional interface built-in
            return "Entered: " + x;
        };
        System.out.println(fx.apply("nice"));

        Predicate<Integer> predicate = (x)->{
            return x > 10;
        };
        System.out.println(predicate.test(20));

        Supplier<Double> supplier = ()->{ // just returns anything from inside
            return 20.3;
        };
        System.out.println(supplier.get());

        Consumer<String> consumer = (x)->{
          System.out.println("Consumed:" + x);
        };
        consumer.accept("vahlol");
    }
}
