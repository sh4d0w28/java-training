package spring.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import paymaster.accounts.AccountTypeEnum;
import paymaster.users.User;
import paymaster.users.UserStorage;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/1")
    public List<User> getUsers() {

        UserStorage storage = new UserStorage();
        return storage.load();
    }
}
