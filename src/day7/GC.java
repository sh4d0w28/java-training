package day7;

import java.sql.Time;
import java.sql.Timestamp;

class CollectableObject {

    public CollectableObject() {
        System.out.println("Created at " + System.nanoTime() );
    }

    @Override
    protected void finalize() {
        System.out.println("Destroyed at " + System.nanoTime() );
    }
}

public class GC {

    public static void main(String args[]) {
        CollectableObject obj1 = new CollectableObject();
        CollectableObject obj2 = new CollectableObject();
        CollectableObject obj3 = new CollectableObject();

        obj1 = null;
        obj2 = null;

        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();

        obj3 = null;

        System.gc();

    }
}
