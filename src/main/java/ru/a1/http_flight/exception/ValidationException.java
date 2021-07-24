package ru.a1.http_flight.exception;

import lombok.Getter;
import ru.a1.http_flight.validator.Error;

import java.util.List;

public class ValidationException extends RuntimeException {

    @Getter
    private final List<Error> errors;


    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
