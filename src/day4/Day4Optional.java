package day4;

//   NEW IN JAVA8

import java.util.Optional;

class OptionalDemo {

    public void doSomething() {
        System.out.println(this);
    }

    public String getValue() {
        return "OptionalDemo::getValue";
    }
}

interface IFunction<T,R> {

    R ifx(T param);
}

public class Day4Optional {

    public static String process(Integer i) {
        return "process::" + i.toString();
    }

    public static long findNb(long m) {
        // your code
        Double sqrtm = Math.sqrt(m);
        long sqrtmi = sqrtm.longValue();
        if (sqrtmi * sqrtmi != m || sqrtm != sqrtmi) {
            return -1;
        }
        Double dsqrt = Math.sqrt(1+8*sqrtmi);
        long dsqrti = dsqrt.longValue();
        if (dsqrt != dsqrti) {
            return -1;
        }
        Double n1 = (dsqrt-1)/2;
        if (n1 > 0 && n1 == n1.intValue()) {
            return n1.intValue();
        }
        return -1;
    }

    public static void main(String[] args) {

        long m = 2212646420610916417L;
        System.out.println(findNb(m));

        if (true) {return;}

        IFunction<Integer, String> fxObj = Day4Optional::process; // we can create function obj here
        fxObj.ifx(2);


        OptionalDemo obj = new OptionalDemo();
        //obj = null;  // object destroyed somehow

        if (obj != null) {    // will have too much checks in real code
            obj.doSomething();
        }

        // OPTIONAL CLASS NOW! ONLY SE-8

        // 1 - if obj is null, of will throw NULLPOINTER exception
        // Optional<OptionalDemo> optDemoObject = Optional.of(obj);

        // 2 - can accept null
        Optional<OptionalDemo> optDemoObjectNullable = Optional.ofNullable(obj);

        // 3 - create empty, can be assigned later on
        Optional<OptionalDemo> optDemoObjectEmpty = Optional.empty();
        optDemoObjectEmpty = Optional.ofNullable(obj);

        optDemoObjectNullable.ifPresent((x) -> {   // executes ONLY is object is exists
            x.doSomething();
        });

        optDemoObjectNullable.map(OptionalDemo::getValue).get();

        // flatMap  - any function inside your class which will RETURN AN OPTIONAL OBJECT
    }
}

//NEED TO CREATE OPTIONAL OBJECT - idea is to check NullPointer

/*

Computer
 - HD
 - USB
 - CDROM (optional)

Computer.CDROM.eject - NullPointerException
Computer.USB.getSerial - NullPointerException

1.How to create:
 - .empty      - create opt-object without any object inside
 - .of         - if object is null will throw NullPointerException
 - .ofNullable -

2.
 - flatMap   - can call any function which return optionalObject type
 - map       - will call any function with any return type ONLY if object is exists
 - filter    - can map to any function which is predicate
 - if (.isPresent) - anything we want
 - .ifPresent - maps to a function
*/