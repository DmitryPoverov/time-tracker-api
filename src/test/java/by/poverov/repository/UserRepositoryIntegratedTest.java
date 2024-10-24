package by.poverov.repository;

import by.poverov.entity.Role;
import by.poverov.entity.User;
import by.poverov.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryIntegratedTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void getAllUsers() {
        List<User> users = userRepository.findAll();
        Assertions.assertNotNull(users);
        Assertions.assertEquals(3, users.size());
    }

    @Test
    void getUserByUserName() {
        Optional<User> user = userRepository.findByUsername("mail1@mail.by");
        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals(1, user.get().getId());
    }

    @Test
    void getFirstUser() {
        Optional<User> user = userRepository.findById(1L);
        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals("mail1@mail.by", user.get().getUsername());
    }

    @Test
    void saveUser() {
        User newUser = User.builder().username("mail4@mail.by").password("123").role(Role.USER).build();
        User savedUser = userRepository.save(newUser);
        Assertions.assertEquals(4, savedUser.getId());
    }

    @Test
    void deleteUser() {
        int sizeBefore = userRepository.findAll().size();
        userRepository.deleteById(1L);
        int sizeAfter = userRepository.findAll().size();
        Assertions.assertEquals(sizeBefore-1, sizeAfter);
    }

    @Test
    void getUserByUser() {
        List<User> users = userRepository.findAll();
        Assertions.assertNotNull(users);
        Assertions.assertEquals(3, users.size());
    }
}
