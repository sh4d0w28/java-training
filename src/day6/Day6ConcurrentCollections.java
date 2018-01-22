package day6;

import java.util.concurrent.*;

public class Day6ConcurrentCollections {

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> countries = new ConcurrentHashMap<>();

        // ConcurrentSkipListMap - faster for access in one direction


        ExecutorService esx = Executors.newCachedThreadPool();
        esx.submit(() -> {
            countries.put("vn", "Vietnam");
        });
        esx.submit(() -> {
            countries.put("my", "Malaysia");
        });
        esx.submit(() -> {
            countries.put("ru", "Russia");
        });

        esx.submit(() -> {
            for(String country : countries.values()) {
                System.out.println(country);
            }
        });

        esx.shutdown(); // no guarantee is will

        try {
            if(!esx.awaitTermination(30, TimeUnit.SECONDS)) {  // will force shutdown after 30 sec or interruption or ..
                esx.shutdownNow(); // will shutdown now
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------");
        CopyOnWriteArrayList<String> wordlist = new CopyOnWriteArrayList<>();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(()-> { wordlist.add("Cats");});
        es.submit(()-> { wordlist.add("Ball");});
        es.submit(()-> { wordlist.add("Dog");});
        es.submit(()-> { wordlist.add("Book");});
        es.submit(() -> {
            for(String word : wordlist) {
                System.out.println(word);
            }
        });

        es.shutdown();
    }
}
