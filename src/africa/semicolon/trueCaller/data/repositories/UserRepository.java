package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findUserByEmail(String userEmail);
}
