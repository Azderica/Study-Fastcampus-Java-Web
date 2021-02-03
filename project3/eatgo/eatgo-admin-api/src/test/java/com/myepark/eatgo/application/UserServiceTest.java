package com.myepark.eatgo.application;

import com.myepark.eatgo.domain.ReviewRepository;
import com.myepark.eatgo.domain.User;
import com.myepark.eatgo.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUsers() {
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(User.builder()
                .email("tester@example.com")
                .name("테스터")
                .level(100L)
                .build());

        given(userRepository.findAll())
                .willReturn(mockUsers);

        List<User> users = userService.getUsers();
        User user = users.get(0);

        assertThat(user.getName()).isEqualTo("테스터");
    }
}