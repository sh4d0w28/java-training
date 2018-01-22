package day5;

// Thread manager in JVM will determine what to do.
// Functional interface for RUNNABLE can be (lambda)

// Since Java SE4 we have Callable

import java.util.Scanner;
import java.util.concurrent.*;

class Simultaneous implements Runnable {  // Runnable - make it parallel

    private String s;

    public Simultaneous(String t) {
        s = t;
    }

    @Override
    public void run() {
        for (int i = 0; i<5; i++) {
            System.out.println("Running parallel" + s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class SimulReturn implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Do something");
        return null;
    }
}

public class Day5Concurrency {

    public static void main(String[] args) throws InterruptedException {

//        Thread job1 = new Thread(new Simultaneous());
//        Thread job2 = new Thread(()->{for(int i=0;i<5;i++){System.out.println("LOL"); try{Thread.sleep(200);} catch (Exception ex){}}});
//        job1.start(); // ask to start, not guarantee
//        //job2.start(); // ask to start, not guarantee
//
//        job2.join(); // ask to join (start ONLY when current job finished
//
//        for(int i = 0; i<5; i++) {
//            System.out.println("Running main");
//            Thread.sleep(500);
//        }

        //ExecutorService es = Executors.newSingleThreadExecutor(); // thread manager -
        //ExecutorService es = Executors.newCachedThreadPool();     // thread manager -
        //ExecutorService es   = Executors.newFixedThreadPool(5);   // thread manager - no more than 2 threads

        ThreadFactory tf = new ThreadFactory() {  /////  ONLY RUNNABLEEE!!!!!!! because it will create new Thread.

            private int tcount = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread#" + (++tcount));
            }
        };

        ExecutorService es   = Executors.newCachedThreadPool();  // thread factory - ONLY FOR RUNNABLE!

        Future<String> result = es.submit(new SimulReturn());       // can submit callable and runnable
        es.submit(new Simultaneous("1"));

        Future<String> resultSubmit = es.submit(new Simultaneous("2"), "Done with runnable");

//        try {
//            System.out.println(result.get());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        System.out.println("Running main....");

        Scanner uin = new Scanner(System.in);
        uin.nextLine();
    }
}
