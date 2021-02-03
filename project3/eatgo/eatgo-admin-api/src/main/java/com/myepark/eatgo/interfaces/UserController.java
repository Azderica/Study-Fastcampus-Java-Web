package com.myepark.eatgo.interfaces;

import com.myepark.eatgo.application.UserService;
import com.myepark.eatgo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    // User list
    // User create ->
    // User update
    // User delete

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list() {
        List<User> users = userService.getUsers();
        return users;
    }

}