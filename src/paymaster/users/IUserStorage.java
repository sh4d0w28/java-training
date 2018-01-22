package paymaster.users;

import java.util.Comparator;

public interface IUserStorage {

    User findUser(String username);
    void printUsers();
    boolean addUser(User u);
    int getSize();
    void sort(Comparator<User> cmp);

}
