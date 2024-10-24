package by.poverov.service;

import by.poverov.entity.Role;
import by.poverov.entity.User;
import by.poverov.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceIntegratedTest {

    @Autowired
    private UserService userService;

    @Test
    void findAll() {
        List<User> allUsersFromService = userService.findAll();

        Assertions.assertNotNull(allUsersFromService);
        Assertions.assertEquals(3, allUsersFromService.size());
    }

    @Test
    void findById() {
        User expectedUser = User.builder().id(1L).username("mail1@mail.by").password("noop{123}").role(Role.ADMIN).build();

        Optional<User> byId = userService.findById(1L);

        Assertions.assertTrue(byId.isPresent());
        Assertions.assertEquals(expectedUser, byId.get());
    }
}