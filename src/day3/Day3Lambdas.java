package day3;

interface Someface {
    void doSomething();
}

public class Day3Lambdas { 
	// 1. LAMBDA - functional interface
	// 2. lambda is a innerclass, non anonymous class

    public static void main(String[] args) {

    	int a = 10;
    	a++;
    	
        Someface obj = () -> {
            //System.out.println("Static here" + a); // a should be final!!! Will cause an error or should not be changed
        };

        obj.doSomething();
    }

}
