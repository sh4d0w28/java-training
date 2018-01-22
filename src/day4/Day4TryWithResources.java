package day4;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class ProcessingClass implements Closeable {

    @Override
    public void close() throws IOException {
        System.out.println("Close " + this.getClass().getName());
    }
}

public class Day4TryWithResources {

    public static void main(String[] args) {

        try(
                FileOutputStream fos = new FileOutputStream("./day4file.txt");   // ONLY CLOSABLES IN HERE!!!!!
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ProcessingClass pc = new ProcessingClass();
        ) {

            // do some operations

            // something happened here

            // fos.close(); - no need anymore, we have closable in try-catch

        } catch (Exception ex) {

        }

    }
}
