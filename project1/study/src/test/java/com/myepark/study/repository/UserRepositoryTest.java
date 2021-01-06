package com.myepark.study.repository;

import com.myepark.study.StudyApplicationTests;
import com.myepark.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;


public class UserRepositoryTest extends StudyApplicationTests {

    // DI, Dependency Injection (의존성 주입)
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional  // 동작은 일어나나 DB에 마지막 롤백이 일어난다.
    public void create() {
        // String sql = insert into user (%s, %s, %d) value (account, eamil, age);
        User user = new User();
        user.setAccount("TestUser02");
        user.setEmail("TestUser02@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    @Transactional  // 동작은 일어나나 DB에 마지막 롤백이 일어난다.
    public void read() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });
    }

    @Test
    @Transactional  // 동작은 일어나나 DB에 마지막 롤백이 일어난다.
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
            System.out.println("user : " + selectUser);
        });

    }

    @Test
    @Transactional  // 동작은 일어나나 DB에 마지막 롤백이 일어난다.
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        Assert.assertFalse(deleteUser.isPresent());

    }

}