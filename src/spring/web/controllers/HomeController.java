package spring.web.controllers;

import com.mvladimirovich.paymaster.users.IUserStorage;
import com.mvladimirovich.paymaster.users.User;
import com.mvladimirovich.paymaster.users.UserFileStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/users")
    public List<User> getUsers() {
        IUserStorage storage = new UserFileStorage();
        return storage.list();
    }
}
