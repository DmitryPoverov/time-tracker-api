package by.poverov.service;

import by.poverov.entity.User;
import by.poverov.repository.UserRepository;
import by.poverov.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private AutoCloseable mocks;

    @BeforeEach
    void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        mocks.close();
    }

    @Test
    void findAll() {
        List<User> expectedUsers = Arrays.asList(
                User.builder().id(1L).username("user1@mail.com").password("123").role(null).records(null).build(),
                User.builder().id(2L).username("user2@mail.com").password("123").role(null).records(null).build());

        Mockito.when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> allUsersFromService = userService.findAll();

        Assertions.assertNotNull(allUsersFromService);
        Assertions.assertEquals(2, allUsersFromService.size());
        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    void findById() {
        Optional<User> expectedUser = Optional.of(
                new User(1L, "user1@mail.com", "password1", null, null));

        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(expectedUser);

        Optional<User> userFromService = userService.findById(1L);

        Assertions.assertTrue(userFromService.isPresent());
        Assertions.assertEquals(1L, userFromService.get().getId());
        Mockito.verify(userRepository, Mockito.times(1)).findById(Mockito.anyLong());
    }

    @Test
    void findNullById() {
        Optional<User> expectedUser = Optional.empty();

        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(expectedUser);

        Optional<User> userFromService = userService.findById(1L);

        Assertions.assertFalse(userFromService.isPresent());
        Mockito.verify(userRepository, Mockito.times(1)).findById(Mockito.anyLong());
    }
}