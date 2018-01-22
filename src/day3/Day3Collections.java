package day3;

import java.util.*;

class SampleData {

    private int data;
    private String name;

    public SampleData(int x, String name){
        this.data = x;
        this.name = name;
    }

    @Override
    public int hashCode() {
        System.out.println("SampleData::hashCode");
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("SampleData::equals");
        return true;
    }
}

public class Day3Collections {

    // Collections - dynamic arrays
    // List - just interface for dynamic array
    // Set - no duplicates array

    static void lists() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Pear");
        fruits.add("Orange");
        fruits.add("Durian");
        fruits.add("Durian");
        fruits.add("Durian");
        fruits.add(2,"Durian");

        System.out.println(fruits.get(2));
        System.out.println(fruits.indexOf("Durian"));

        fruits.removeIf((x)->x=="Durian");

        fruits.forEach(x->System.out.println(x));    // ITERATOR

        Iterator<String> iter = fruits.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    static void sets() {
        Set<String> people = new HashSet<>();
        people.add("D-5021");
        people.add("D-5019");
        people.add("D-5910");
        people.add("D-4124");
        people.add("D-4124");
        people.add("D-4124");
        people.add("D-4124");
        people.add("D-4128");

        for (String person : people) {
            System.out.println(person);
        }

        Set<SampleData> dataSet = new HashSet();
        dataSet.add(new SampleData(10, "1"));
        dataSet.add(new SampleData(11, "2"));
        dataSet.add(new SampleData(10, "3"));

        // we have same hashcode, so we will try to check if they are equals

    }

    static void queues(){

        // Queue / Deque / Stack / Map
        Queue<String> lineup = new LinkedList<>();
        lineup.add("D-00001");
        lineup.add("D-00002");
        lineup.add("D-00003");
        lineup.add("D-00004");
        lineup.add("D-00005");

        System.out.println(lineup.peek()); // see item
        System.out.println(lineup.poll()); // display AND remove
        System.out.println( " --- QUEUE --- ");
        for(String item: lineup) {
            System.out.println(item);
        }


        Deque<String> lineupDeque = new LinkedList<>();
        lineupDeque.add("D-00001"); // addLast
        lineupDeque.add("D-00002");
        lineupDeque.add("D-00003");
        lineupDeque.add("D-00004");
        lineupDeque.add("D-00005");
        lineupDeque.addFirst("D-00000");

        System.out.println( " --- DEQUEUE --- ");

        System.out.println(lineupDeque.peekLast()); // see item
        System.out.println(lineupDeque.pollLast()); // display AND remove
        System.out.println( " --- DEQUEUE STAT --- ");
        for(String item: lineup) {
            System.out.println(item);
        }

        Stack<String> operations = new Stack(); // STACK IS A CLASS!
        operations.push("TEST");
        operations.push("TEST2");
        System.out.println( operations.peek() );
        System.out.println( operations.pop() );

    }

    static void maps(){

        Map<String, String> countries = new HashMap<>(); // WILL SORT KEYS FOR ME
        countries.put("ru", "Russia");
        countries.put("vn", "Vietnam");
        countries.put("lk", "Sri Lanka");
        countries.put("th", "Thailand");

        System.out.println(countries.get("ru"));

        countries.keySet().forEach((key)->{System.out.println(countries.get(key));});

        List<String> sortedList = new ArrayList<>();
        sortedList.addAll(countries.keySet());

        Collections.sort(sortedList);

        sortedList.forEach(x->System.out.println(countries.get(x))); // sort keys

        // Collection - kinda interface
        // Collections - utility class
    }

    public static void main(String[] args) {
        maps();
    }
}
