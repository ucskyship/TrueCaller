package africa.semicolon.trueCaller.data.repositoriess;

import africa.semicolon.trueCaller.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private int counter;
    private final List<User> users = new ArrayList<>();

    @Override
    public User saveUser(User user) {
        User lookForUser = findById(user.getId());
        if (lookForUser != null) {
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setEmail(user.getEmail());
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
        } else {
            counter++;
            user.setId(counter);
            users.add(user);
        }
        return user;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
//        counter--;
    }

    @Override
    public void delete(int id) {
        User lookForUser = findById(id);
        if (lookForUser.getId() == id) {
            users.remove(lookForUser);
        }
//        counter --;
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User searchUser(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
            break;
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
            break;
        }
        return null;
    }
}
