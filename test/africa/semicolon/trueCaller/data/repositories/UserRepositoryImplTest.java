package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    UserRepository userRepository;
    User user;
    User user2;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
        user = new User();
        user2 = new User();
    }

    @Test
    public void saveUserTest() {
        user.setFirstName("Peter James");
        user.setLastName("Peter");
        user.setUsername("peter1212");
        user.setPassword("02abc");
        user.setEmail("peter1212@gmail.com");
        userRepository.saveUser(user);
        assertEquals(1, userRepository.count());
        assertEquals("peter1212@gmail.com", user.getEmail());
    }

    @Test
    public void findById() {
        user.setFirstName("Peter James");
        user.setLastName("James");
        user.setUsername("peter1212");
        user.setPassword("02abc");
        user.setEmail("peter1212@gmail.com");
        userRepository.saveUser(user);
        assertEquals(1, userRepository.count());
        User userSaved = userRepository.findById(1);
        assertEquals("peter1212", userSaved.getUsername());
    }

    @Test
    public void delete_byIdTest() {
        user.setFirstName("Peter James");
        user.setLastName("James");
        user.setUsername("peter1212");
        user.setPassword("02abc");
        user.setEmail("peter1212@gmail.com");
        userRepository.saveUser(user);
        assertEquals(1, userRepository.count());

        userRepository.delete(1);
        assertEquals(0, userRepository.count());
    }

    @Test
    public void delete_byUserTest() {
        user.setFirstName("Peter James");
        user.setLastName("Peter");
        user.setUsername("peter1212");
        user.setPassword("02abc");
        user.setEmail("peter1212@gmail.com");
        userRepository.saveUser(user);
        assertEquals(1, userRepository.count());

        userRepository.delete(user);
        assertEquals(0, userRepository.count());
    }

    @Test
    public void updateTest_ifUserAlreadyExistsUpdateDetails() {
        user.setFirstName("Peter James");
        user.setLastName("James");
        user.setUsername("peter1212");
        user.setPassword("02abc");
        user.setEmail("peter1212@gmail.com");
        userRepository.saveUser(user);
        assertEquals(1, userRepository.count());

        user.setFirstName("Mike Smith");
        user.setLastName("Smith");
        user.setUsername("smith1212");
        user.setPassword("00bn");
        user.setEmail("smith212@gmail.com");
        userRepository.saveUser(user);

        assertEquals(1, userRepository.count());
    }

    @Test
    public void findAllTest() {
        user.setFirstName("Mike Smith");
        user.setLastName("Smith");
        user.setUsername("peter1212");
        user.setPassword("02abc");
        user.setEmail("peter1212@gmail.com");
        userRepository.saveUser(user);

        user.setFirstName("Mike Smith");
        user.setLastName("Smith");
        user2.setUsername("smith1212");
        user2.setPassword("00bn");
        user2.setEmail("smith212@gmail.com");
        userRepository.saveUser(user2);

        assertEquals(2, userRepository.findAll().size());
    }

    @Test
    public void testThatWeCanSearchUser() {
        user.setFirstName("Peter James");
        user.setLastName("James");
        user.setUsername("peter1212");
        user.setPassword("02abc");
        user.setEmail("peter1212@gmail.com");
        userRepository.saveUser(user);

        user2.setFirstName("Mike Smith");
        user2.setLastName("Smith");
        user2.setUsername("smith1212");
        user2.setPassword("00bn");
        user2.setEmail("smith212@gmail.com");
        userRepository.saveUser(user2);

        assertEquals(2, userRepository.findAll().size());

        User searchedUser = userRepository.searchUser("peter1212");
        assertEquals("peter1212", searchedUser.getUsername());
    }
}