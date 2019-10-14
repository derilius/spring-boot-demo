package pl.derilius.demo.exception;

class NotFoundException extends RuntimeException {

    NotFoundException() {
    }

    NotFoundException(String message) {
        super(message);
    }

}
