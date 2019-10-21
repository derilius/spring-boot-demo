package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.user.dto.PasswordResetApi;
import pl.derilius.demo.domain.user.dto.RegisterApi;
import pl.derilius.demo.domain.user.dto.User;
import pl.derilius.demo.exception.LoginNotFoundException;
import pl.derilius.demo.exception.ValidationFailedException;
import pl.derilius.demo.exception.ValueTakenException;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final LoginRepository loginRepository;
    private final RoleService roleService;

    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, LoginRepository loginRepository, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.loginRepository = loginRepository;
        this.roleService = roleService;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = loginRepository.findByMail(username)
                .map(UserMapper::dto);

        return user.orElseThrow(() -> new UsernameNotFoundException("Not Found"));
    }

    Login register(RegisterApi api, People people) {
        checkMail(api.getMail());
        Role role = roleService.getRole(Role.Name.USER);
        Login login = new Login(api.getMail(), passwordEncoder.encode(api.getPassword()), role, people);
        return loginRepository.save(login);
    }

    private void checkMail(String mail) {
        boolean unavailable = loginRepository.findByMail(mail).isPresent();
        if (unavailable)
            throw new ValueTakenException("mail already taken");
    }

    void activate(String token) {
        Optional<Login> login = loginRepository.findByActivateToken(token);
        if (login.isPresent()) {
            login.get().activate();
            loginRepository.save(login.get());
        } else
            throw new LoginNotFoundException();
    }

    Login remindPassword(String mail) {
        Optional<Login> login = loginRepository.findByMail(mail);
        if (login.isPresent()) {
            login.get().remindPassword();
            return loginRepository.save(login.get());
        } else
            throw new LoginNotFoundException();
    }

    void resetPassword(String token, PasswordResetApi api) {
        checkNewPassword(api);
        Optional<Login> login = loginRepository.findByPasswordToken(token);
        if (login.isPresent()) {
            login.get().resetPassword(passwordEncoder.encode(api.getNewPassword()));
            loginRepository.save(login.get());
        } else
            throw new LoginNotFoundException();
    }

    private void checkNewPassword(PasswordResetApi api) {
        if (!api.getNewPassword().equals(api.getRepeatedPassword()))
            throw new ValidationFailedException("Passwords are not the same");
    }

}
