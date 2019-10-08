package pl.derilius.demo.domain.user;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserRepository {

    private HashMap<Long, User> userTable = new HashMap<>();
    private AtomicLong userId = new AtomicLong(1);

    User save(User user) {
        userTable.put(userId.getAndAdd(1), user);
        return user;
    }

    Optional<User> findByUsername(String username) {
        return userTable.values()
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

}
