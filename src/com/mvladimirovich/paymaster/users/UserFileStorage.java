package com.mvladimirovich.paymaster.users;

import com.mvladimirovich.paymaster.common.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class UserFileStorage implements IUserStorage {

    private static final String storage = "/home/mvladimirovich/IdeaProjects/test/newstorage.bin";
    private static final String ERR_CANNOTSAVE = "Cannot save data";
    private static final String ERR_CANNOTLOAD = "Cannot load data";

    public List<User> users;

    public UserFileStorage() {
        users = new ArrayList<>();
    }

    private List<User> loadFromFS() {
        try (FileInputStream binaryFis = new FileInputStream(storage);
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

    private boolean saveToFS() {
        try (FileOutputStream binaryFos = new FileOutputStream(storage);
             ObjectOutputStream oos = new ObjectOutputStream(binaryFos);
        ) {
            oos.writeObject(users);
            paymaster.log.Log.printlnGood("Data saved to " + storage);
            return true;
        } catch (Exception ex) {
            paymaster.log.Log.printlnError(ERR_CANNOTSAVE);
            return false;
        }
    }

    @Override
    public List<User> list() {
        loadFromFS();
        return users;
    }

    @Override
    public boolean add(User u) {
        users.add(u);
        return saveToFS();
    }

    @Override
    public User get(String name) {
        loadFromFS();
        for(User user: users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean update(User u) {
        loadFromFS();
        for(User user: users) {
            if (user.getName().equals(u.getName())) {
                users.set(users.indexOf(user), u);
            }
        }
        saveToFS();
        return true;
    }

    @Override
    public List<User> sort(Comparator<User> cmp) {
        loadFromFS();
        users.sort(cmp);
        return users;
    }
}
