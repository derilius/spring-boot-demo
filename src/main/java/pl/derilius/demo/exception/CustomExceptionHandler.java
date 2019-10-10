package pl.derilius.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ValueTakenException.class})
    public ResponseEntity<Object> handleValueTakenException(Exception ex) {
        ex.printStackTrace();
        ErrorDTO error = new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler({PreconditionFailedException.class})
//    public ResponseEntity<ApiError> handlePreconditionException(Exception ex) {
//        ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.PRECONDITION_FAILED, ex.getStackTrace());
//        return new ResponseEntity<>(apiError, HttpStatus.PRECONDITION_FAILED);
//    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        Map<String, String> details = new HashMap<>();
//        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
//            if (error.getCodes() != null && error.getCodes().length > 1)
//                details.putIfAbsent(error.getCodes()[1].split("\\.")[1], error.getDefaultMessage());
//        }
//        ApiError apiError = new ApiError(VALIDATION_FAILED, HttpStatus.BAD_REQUEST, details);
//        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
//    }

}
