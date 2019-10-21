package pl.derilius.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ValueTakenException.class})
    public ResponseEntity<Object> handleValueTakenException(ValueTakenException ex) {
        ex.printStackTrace();
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        ex.printStackTrace();
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ValidationFailedException.class})
    public ResponseEntity<Object> handleValidationFailedException(ValidationFailedException ex) {
        ex.printStackTrace();
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.PRECONDITION_FAILED);
        return new ResponseEntity<>(error, HttpStatus.PRECONDITION_FAILED);
    }

}
