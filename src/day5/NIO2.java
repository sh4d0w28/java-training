package day5;

import paymaster.accounts.CheckingAccount;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

   // syncrhonized - function
  // callable - runnable
 // locks types on exam
// OMG!

public class NIO2 {

    public static void main(String[] args) {

        Path fileLoc = Paths.get("./generated_file.bin");
        Path newLoc = Paths.get("./copied_generated_file.bin");

        if (Files.notExists(fileLoc)) {
            try {
                Set<PosixFilePermission> perm = new HashSet<>();   // set permissions object
                perm.add(PosixFilePermission.OWNER_READ);
                perm.add(PosixFilePermission.OWNER_WRITE);
                perm.add(PosixFilePermission.GROUP_READ);
                perm.add(PosixFilePermission.OTHERS_READ);

                FileAttribute<Set<PosixFilePermission>> p644 = PosixFilePermissions.asFileAttribute(perm); // convert to fattrs
                Files.createFile(fileLoc, p644);
                Files.copy(fileLoc, newLoc, StandardCopyOption.REPLACE_EXISTING);
                Files.move(newLoc, fileLoc, StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        CheckingAccount obj = new CheckingAccount("JD", 100);
        ObjectOutputStream oos;


        try {
            oos = new ObjectOutputStream(Files.newOutputStream(fileLoc));
            oos.writeObject(obj);

            Files.copy(fileLoc, newLoc, StandardCopyOption.REPLACE_EXISTING);

            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(newLoc));
            obj = (CheckingAccount)ois.readObject();

            System.out.println(obj.toString());

            Files.delete(fileLoc);
            Files.delete(newLoc);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
