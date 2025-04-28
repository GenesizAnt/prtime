package ru.gen.prtime.calendarManaged.api.exhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.gen.prtime.calendarManaged.api.exhandlers.exceptions.AlreadyExistsException;
import ru.gen.prtime.calendarManaged.api.exhandlers.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class ApiExceptionHandler {
    //ToDo подумать над названием класса

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException ex) {
        List<Map<String, String>> errors = ex.getFieldErrors().stream()
                .map(fieldError -> Map.of(
                        "поле", fieldError.getField(),
                        "сообщение", Objects.requireNonNull(fieldError.getDefaultMessage())
                ))
                .toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> handleAlreadyExistsException(AlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
