package pl.derilius.demo.exception;

public class LoginNotFoundException extends NotFoundException {

    private static String MSG = "LOGIN_NOT_FOUND";

    public LoginNotFoundException() {
        super(MSG);
    }

    public LoginNotFoundException(String message) {
        super(message);
    }

}
