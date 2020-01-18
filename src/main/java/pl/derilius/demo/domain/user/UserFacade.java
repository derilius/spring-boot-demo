package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.user.dto.PasswordResetApi;
import pl.derilius.demo.domain.user.dto.RegisterApi;
import pl.derilius.demo.domain.user.dto.User;

@Service
public class UserFacade {

    private final LoginService loginService;
    private final PeopleService peopleService;

    @Autowired
    public UserFacade(LoginService loginService, PeopleService peopleService) {
        this.loginService = loginService;
        this.peopleService = peopleService;
    }

    public void register(RegisterApi api) {
        Person person = peopleService.create(api);
        Login login = loginService.register(api, person);
        User user = UserMapper.dto(login);
    }

    public void activateUser(String token) {
        loginService.activate(token);
    }

    public void remindUserPassword(String mail) {
        Login login = loginService.remindPassword(mail);
        User user = UserMapper.dto(login);
    }

    public void resetUserPassword(String token, PasswordResetApi api) {
        loginService.resetPassword(token, api);
    }
}
