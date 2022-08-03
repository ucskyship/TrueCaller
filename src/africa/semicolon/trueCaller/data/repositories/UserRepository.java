package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);
    void delete(User user);
    void delete(int id);
    User findById(int id);
    int count();
    List<User> findAll();
    User searchUser(String username);

    User findByEmail(String email);
}
