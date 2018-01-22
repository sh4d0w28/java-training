package paymaster.users;

import paymaster.log.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserStorage implements IUserStorage {

    public static final String storage = "./storage.bin";

    private static final String ERR_CANNOTSAVE = "Cannot save data";
    private static final String ERR_CANNOTLOAD = "Cannot load data";

    public List<User> users = new ArrayList<>();

    public void Save() {
        try (FileOutputStream binaryFos = new FileOutputStream(UserStorage.storage);
             ObjectOutputStream oos = new ObjectOutputStream(binaryFos);
        ) {
            oos.writeObject(users);
            Log.printlnGood("Data saved to " + storage);
        } catch (Exception ex) {
            Log.printlnError(ERR_CANNOTSAVE);
        }
    }

    public List<User> load() {
        try (FileInputStream binaryFis = new FileInputStream(UserStorage.storage);
             ObjectInputStream ois = new ObjectInputStream(binaryFis);
        ) {
            Object obj = ois.readObject();
            List<User> result = (List<User>) obj;
            Log.printlnGood("Data loaded from " + storage);
            users = result;
            return result;

        } catch (Exception ex) {
            Log.printlnError(ERR_CANNOTLOAD);
            return new ArrayList<>();
        }
    }

    public User findUser(String username) {
        for(User u: users) {
            if (u.getName().equals(username)) {
                return u;
            }
        }
        Log.printlnError("User not found");
        return null;
    }

    public void printUsers() {
        System.out.println(" --- --- --- ");
        System.out.println(" USERS LIST  ");
        System.out.println(" --- --- --- ");
        users.forEach(x->{System.out.format("NAME: %s ACCID: %d BAL: %f\n", x.getName(), x.getAccount().getId(), x.getAccount().getBalance());});
        System.out.println(" --- --- --- ");
    }

    public boolean addUser(User user) {

        synchronized (this.users) {
            this.users.add(user);
        }
        return true;
    }

    public int getSize() {
        return users.size();
    }

    public void sort(Comparator<User> cmp) {
        users.sort(cmp);
    }
}
