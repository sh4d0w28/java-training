package day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day5SyncLocks {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();

        myList.add("One");
        myList.add("Two");
        myList.add("Free!");
        myList.add("For");
        myList.add("Fife");

        Iterator<String> i = myList.iterator();
        int counter = 0;

        while(i.hasNext()) {
            counter++;
            if(counter == 3) {
                // myList.remove(3); // concurrency exception
                i.remove(); // safe
            }
            System.out.println(i.next());
        }
    }
}
