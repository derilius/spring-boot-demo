package pl.derilius.demo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.derilius.demo.domain.notification.NotificationService;
import pl.derilius.demo.domain.user.dto.PasswordResetApi;
import pl.derilius.demo.domain.user.dto.RegisterApi;
import pl.derilius.demo.domain.user.dto.User;

@Service
public class UserFacade {

    private final LoginService loginService;
    private final PeopleService peopleService;
    private final NotificationService notificationService;

    @Autowired
    public UserFacade(LoginService loginService, PeopleService peopleService, NotificationService notificationService) {
        this.loginService = loginService;
        this.peopleService = peopleService;
        this.notificationService = notificationService;
    }

    public void register(RegisterApi api) {
        People people = peopleService.create(api);
        Login login = loginService.register(api, people);
        User user = UserMapper.dto(login);
        notificationService.sendActivationMail(user, login.getActivateToken());
    }

    public void activateUser(String token) {
        loginService.activate(token);
    }

    public void remindUserPassword(String mail) {
        Login login = loginService.remindPassword(mail);
        User user = UserMapper.dto(login);
        notificationService.sendResetPasswordMail(user, login.getPasswordToken());
    }

    public void resetUserPassword(String token, PasswordResetApi api) {
        loginService.resetPassword(token, api);
    }
}
