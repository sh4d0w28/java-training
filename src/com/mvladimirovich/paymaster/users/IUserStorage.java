package com.mvladimirovich.paymaster.users;

import java.util.Comparator;
import java.util.List;

public interface IUserStorage {

    List<User> list();
    boolean add(User u);
    User get(String name);
    List<User> sort(Comparator<User> cmp);
    boolean update(User u);
}
