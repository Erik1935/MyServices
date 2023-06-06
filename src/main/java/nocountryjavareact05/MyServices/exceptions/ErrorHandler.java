package nocountryjavareact05.MyServices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).findFirst().get();
        ErrorDTO error = new ErrorDTO("Validation failed", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                msg.substring(0, 1).toUpperCase() + msg.substring(1).toLowerCase());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(CustomConflictException.class)
    public ResponseEntity<ErrorDTO> handleValueAlreadyExistsException(CustomConflictException ex) {
        ErrorDTO error = ex.getError();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(CustomNotFoundException ex) {
        ErrorDTO error = ex.getError();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleAuthenticationException(Exception ex) {
        ErrorDTO error = new ErrorDTO("Unknown error",
                String.valueOf(HttpStatus.BAD_REQUEST.value()),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}