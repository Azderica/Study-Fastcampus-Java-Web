package com.myepark.eatgo.application;

import com.myepark.eatgo.domain.EmailExistedException;
import com.myepark.eatgo.domain.User;
import com.myepark.eatgo.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class UserServiceTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepostory;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerUser() {
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        userService.registerUser(email, name, password);

        verify(userRepostory).save(any());
    }

    @Test
    public void registerUserWithExistedEmail() {
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        User user = User.builder().build();
        given(userRepostory.findByEmail(email)).willReturn(Optional.of(user));

        assertThatThrownBy(() -> {
            userService.registerUser(email, name, password);
        }).isInstanceOf(EmailExistedException.class);

        verify(userRepostory, never()).save(any());
    }

}
