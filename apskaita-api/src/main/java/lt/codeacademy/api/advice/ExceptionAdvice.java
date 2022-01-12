package lt.codeacademy.api.advice;

import lt.codeacademy.api.exception.AccountNotFoundException;
import lt.codeacademy.api.exception.ClientNotFoundException;
import lt.codeacademy.api.exception.data.ExceptionResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingAccountNotFound(AccountNotFoundException exception) {
        return new ExceptionResponse(String.format("Account %s not found", exception.getId()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingCounterpartyNotFound(ClientNotFoundException exception) {
        return new ExceptionResponse(String.format("Counterparty %s not found", exception.getId()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingEmptyResult(EmptyResultDataAccessException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
