package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkSync implements Runnable {

    private static boolean canRead = false;
    public static String dataStr;

    public WorkSync(boolean readable) {
        canRead = readable;
    }

    public synchronized void setString(String x) { // tell that thread manager (ES) to run this function with locked object
        dataStr = x;
    }

    public void doSomething() {
        // some preprocessing

        synchronized (this) {

        }

        // some finalization code
    }

    public synchronized String readString() {
        System.out.println("WorkSync::readString");
        return dataStr;
    }

    @Override
    public void run() {
        if(canRead) {
            readString();
        } else {
            setString("NewValue");
        }
    }
}


public class Day5Synchronize {

    public static void main(String[] args) {

        WorkSync obj = new WorkSync(true);

        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(obj);
        es.submit(obj);
        es.submit(obj);
        es.submit(obj);
        es.submit(obj);
        es.submit(obj);
        es.submit(obj);
    }


}
