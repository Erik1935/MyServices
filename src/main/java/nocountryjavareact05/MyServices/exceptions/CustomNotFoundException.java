package nocountryjavareact05.MyServices.exceptions;

import org.springframework.http.HttpStatus;

public class CustomNotFoundException extends RuntimeException {
    private ErrorDTO error;

    public CustomNotFoundException(String message) {
        super(message);
        this.error = new ErrorDTO("Resource not found", String.valueOf(HttpStatus.NOT_FOUND.value()), message);
    }

    public ErrorDTO getError() {
        return error;
    }
}