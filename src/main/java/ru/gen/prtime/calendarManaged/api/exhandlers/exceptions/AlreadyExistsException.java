package ru.gen.prtime.calendarManaged.api.exhandlers.exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
