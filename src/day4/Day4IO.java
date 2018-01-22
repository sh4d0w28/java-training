package day4;

import day4.assets.Customer;

import java.io.*;

public class Day4IO {

    public static void main(String[] args)
    {
        try (
                FileOutputStream binaryFos = new FileOutputStream("./binary.bin");
                ObjectOutputStream oos = new ObjectOutputStream(binaryFos);
                FileInputStream binaryFis = new FileInputStream("./binary.bin");
                ObjectInputStream ois = new ObjectInputStream(binaryFis);

                //FileOutputStream fos = new FileOutputStream("./storage.txt"); // output class - writer
                //FileInputStream fis = new FileInputStream("./storage.txt");   // input class  - reader
                //PrintWriter pw = new PrintWriter(fos); // transforms out to file
                //Scanner fscan = new Scanner(fis);
        ) {
            Customer mCustomer = new Customer("Max");

            oos.writeObject(mCustomer);
            oos.close();

            Object cObj = ois.readObject();
            Customer readed;
            if (cObj instanceof Customer) {
                readed = (Customer)cObj;
                System.out.println(readed.toString());
                //System.out.println(readed.getAmount());
            }

            //pw.println("LOL");  // can be written, except Optional
            //pw.flush();
            //System.out.println(fscan.nextLine());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
