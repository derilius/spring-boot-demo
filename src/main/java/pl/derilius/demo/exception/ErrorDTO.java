package pl.derilius.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
class ErrorDTO {

    private String message;
    private HttpStatus status;

    ErrorDTO(String message, HttpStatus httpStatus) {
        this.message = message;
        this.status = httpStatus;
    }

}
