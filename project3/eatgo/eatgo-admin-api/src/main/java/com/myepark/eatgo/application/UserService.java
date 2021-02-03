package com.myepark.eatgo.application;

import com.myepark.eatgo.domain.User;
import com.myepark.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepositoy;

    @Autowired
    public UserService(UserRepository userRepositoy) {
        this.userRepositoy = userRepositoy;
    }

    public List<User> getUsers() {
        List<User> users = userRepositoy.findAll();

        return users;
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .build();

        return userRepositoy.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        // TODO: restaurantService의 예외 처리 참고.
        User user = userRepositoy.findById(id).orElse(null);

        user.setEmail(email);
        user.setName(name);
        user.setLevel(level);

        return user;
    }

    public User deactiveUser(Long id) {
        // TODO: restaurantService의 예외 처리 참고.
        User user = userRepositoy.findById(id).orElse(null);

        user.deativate();

        return user;
    }

}
