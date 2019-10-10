package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.user.dto.RegisterApi;
import pl.derilius.demo.domain.user.dto.UserDTO;
import pl.derilius.demo.exception.ValueTakenException;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        addUser();
    }

    private void addUser() {
        User user = new User(1L, "Jan", "Kowalski", "admin", passwordEncoder.encode("testtest"));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDTO> user = userRepository.findByUsername(username)
                .map(UserMapper::dto);

        return user.orElseThrow(() -> new UsernameNotFoundException("Not Found"));
    }

    public void register(RegisterApi api) {
        checkUsername(api.getUsername());
        User user = new User(api, passwordEncoder.encode(api.getPassword()));
        userRepository.save(user);
    }

    private void checkUsername(String username) {
        boolean unavailable = userRepository.findByUsername(username).isPresent();
        if (unavailable)
            throw new ValueTakenException("username already taken");
    }

}
