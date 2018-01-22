package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Day5Locks {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(); // simple full lock
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(); // RWLOCK:

        //ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(() -> {
            rwLock.readLock().lock();
            System.out.println("1 First task executing");

//            System.out.println("1 This task holding lock: " + lock.isHeldByCurrentThread());
//            System.out.println("1 Is thread locked: " + lock.isLocked());
            rwLock.readLock().lock();
        });
        es.submit(() -> {
            rwLock.readLock().lock();
            System.out.println("2 Secnd task executing");

//            lock.lock(); // it will lock all other from executing until unclock
//            System.out.println("2 This task holding lock: " + lock.isHeldByCurrentThread());
//            System.out.println("2 Is thread locked: " + lock.isLocked());

            rwLock.readLock().unlock();
        });
        es.submit(() -> {
            rwLock.readLock().lock();
            System.out.println("3 Third task executing");

//            System.out.println("3 This task holding lock: " + lock.isHeldByCurrentThread());
//            System.out.println("3 Is thread locked: " + lock.isLocked());
            rwLock.readLock().unlock();
        });

        return;
    }
}
