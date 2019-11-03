package com.algaworks.algamoney.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        String messageUser = messageSource.getMessage("unknown.property", null, Locale.getDefault());
        String debugMessage = ex.getCause() != null? ex.getCause().toString() : ex.toString();
        return handleExceptionInternal(ex, List.of(new Error(messageUser, debugMessage)), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error> errors = getErrors(ex.getBindingResult());
        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
        String messageUser = messageSource.getMessage("resource.not-found", null, Locale.getDefault());
        String debugMessage = ex.getCause() != null? ex.getCause().toString() : ex.toString();
        return handleExceptionInternal(ex, List.of(new Error(messageUser, debugMessage)), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        String messageUser = messageSource.getMessage("resource.not-allowed", null, Locale.getDefault());
        String debugMessage = ExceptionUtils.getRootCauseMessage(ex);
        return handleExceptionInternal(ex, List.of(new Error(messageUser, debugMessage)), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ClientNotFoundOrInactiveException.class})
    public ResponseEntity<Object> handleClientNotFoundOrInactiveException(ClientNotFoundOrInactiveException ex) {
        String messageUser = messageSource.getMessage("resource.client.invalid", null, Locale.getDefault());
        String debugMessage = ExceptionUtils.getRootCauseMessage(ex);
        return ResponseEntity.badRequest().body(List.of(new Error(messageUser, debugMessage)));
    }

    private List<Error> getErrors(BindingResult bindResult) {
        return bindResult
                .getFieldErrors()
                .stream()
                .map(fieldError -> new Error(messageSource.getMessage(fieldError, Locale.getDefault()), fieldError.toString()))
                .collect(Collectors.toList());
    }

    @AllArgsConstructor
    @Getter
    @Setter
    private static class Error {
        private String messageUser;

        private String debugMessage;
    }
}
