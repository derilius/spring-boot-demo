package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private HashMap<Long, UserDTO> userTable = new HashMap<>();

    @Autowired
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        addUser();
    }

    private void addUser() {
        UserDTO user = new UserDTO(1L, "user", passwordEncoder.encode("testtest"));
        userTable.put(1L, user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserDTO> user = userTable.values()
                .stream()
                .filter(u -> u.getLogin().equalsIgnoreCase(s))
                .findAny();

        return user.orElseThrow(() -> new UsernameNotFoundException("Not Found"));
    }

}
