package pl.derilius.demo.exception;

public class RoleNotFoundException extends NotFoundException {

    private static String MSG = "ROLE_NOT_FOUND";

    public RoleNotFoundException() {
        super(MSG);
    }

    public RoleNotFoundException(String message) {
        super(message);
    }

}
