package pl.derilius.demo.exception;

public class ValidationFailedException extends RuntimeException {

    public ValidationFailedException(String msg) {
        super(msg);
    }

}
