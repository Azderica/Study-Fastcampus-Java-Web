package com.myepark.eatgo.application;

import com.myepark.eatgo.domain.User;
import com.myepark.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepostory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String email, String name, String password) {
        Optional<User> existed = userRepostory.findByEmail(email);
        if (existed.isPresent()) {
            throw new EmailExistedException(email);
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = User.builder()
                .email(email)
                .name(name)
                .password(encodedPassword)
                .level(1L)
                .build();

        return userRepostory.save(user);
    }
}
