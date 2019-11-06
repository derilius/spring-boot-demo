package pl.derilius.demo.domain.notification;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
//import pl.derilius.demo.domain.user.dto.User;
//
@Service
public class NotificationService {
//
//    private static final String ACTIVATE_ACCOUNT = "Activate account";
//    private static final String RESET_PASSWORD = "Reset password";
//    private JavaMailSender mailSender;
//
//    @Autowired
//    public NotificationService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    public void sendActivationMail(User user, String activateToken) {
//        SimpleMailMessage mailMessage = prepareMail(user.getMail(), ACTIVATE_ACCOUNT, activateToken);
//        sendMail(mailMessage);
//    }
//
//    public void sendResetPasswordMail(User user, String passwordToken) {
//        SimpleMailMessage mailMessage = prepareMail(user.getMail(), RESET_PASSWORD, passwordToken);
//        sendMail(mailMessage);
//    }
//
//    private SimpleMailMessage prepareMail(String to, String subject, String body) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//        return message;
//    }
//
//    private void sendMail(SimpleMailMessage mailMessage) {
//        final Runnable cmd = () -> mailSender.send(mailMessage);
//        new Thread(cmd).start();
//    }
//
}
