package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
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
    private final RoleService roleService;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public UserDTO loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDTO> user = userRepository.findByUsername(username)
                .map(UserMapper::dto);

        return user.orElseThrow(() -> new UsernameNotFoundException("Not Found"));
    }

    public void register(RegisterApi api) {
        checkUsername(api.getUsername());
        Role role = roleService.getRole(Role.Name.USER);
        User user = new User(api, passwordEncoder.encode(api.getPassword()), role);
        userRepository.save(user);
    }

    private void checkUsername(String username) {
        boolean unavailable = userRepository.findByUsername(username).isPresent();
        if (unavailable)
            throw new ValueTakenException("username already taken");
    }

}
