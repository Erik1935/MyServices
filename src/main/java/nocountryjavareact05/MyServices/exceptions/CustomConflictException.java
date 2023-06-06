package nocountryjavareact05.MyServices.exceptions;

import org.springframework.http.HttpStatus;

public class CustomConflictException extends RuntimeException {
    private ErrorDTO error;

    public CustomConflictException(String message) {
        super(message);
        this.error = new ErrorDTO("Value already exists", String.valueOf(HttpStatus.CONFLICT.value()), message);
    }

    public ErrorDTO getError() {
        return error;
    }
}