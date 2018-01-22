package day4;

import day2.assets.Child;
import day2.assets.Parent;
import paymaster.accounts.Account;

import java.util.ArrayList;
import java.util.List;

class Custom<T> {
    public List<T> doSomething(List<? extends T> obj) { // return a list of any object. Object SHOULD EXTEND T type
        //TODO: do something to obj
        return new ArrayList<T>();
    }
}

public class Day4Wildcards {

    public static <T> void madness(Custom<? extends T> obj) {

    }

    public static void process(Custom<? super Child> obj) {

    }

    public static void process3(List<?> myList) {    // WILDCARD, any class at all  == <? extends Object>

    }

    public static void process2(List<? extends Parent> myList) {    // WILDCARD, any class from Parent == <? extends Object>

    }

    public static void main(String args[]) {
        process3(new ArrayList<String>());
        process2(new ArrayList<Child>());

        process(new Custom<Object>());
        process(new Custom<Parent>());
        process(new Custom<Child>());

        Custom<Parent> something = new Custom<>();
        // something.doSomething(new ArrayList<Integer>()); // NOT OK! Object not extends Parent
        something.doSomething(new ArrayList<Parent>());  // OK
        something.doSomething(new ArrayList<Child>());  // OK

    }
}
