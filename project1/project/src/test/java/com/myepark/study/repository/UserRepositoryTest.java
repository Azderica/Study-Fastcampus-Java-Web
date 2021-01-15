package com.myepark.study.repository;

import com.myepark.study.StudyApplicationTests;
import com.myepark.study.model.entity.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Ignore
public class UserRepositoryTest extends StudyApplicationTests {

    // DI, Dependency Injection (의존성 주입)
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional  // 동작은 일어나나 DB에 마지막 롤백이 일어난다.
    public void create() {
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer"

    }

    @Test
    @Transactional  // 동작은 일어나나 DB에 마지막 롤백이 일어난다.
    public void read() {

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