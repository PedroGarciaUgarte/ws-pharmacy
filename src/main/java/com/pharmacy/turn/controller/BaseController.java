package com.pharmacy.turn.controller;

import java.sql.Timestamp;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pharmacy.turn.domain.ErrorResponse;
import com.pharmacy.turn.exception.PharmacyRestException;
import com.pharmacy.turn.exception.PharmacyException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@ControllerAdvice
public class BaseController {

    public HttpHeaders getResponseHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        responseHeaders.set("Access-Control-Allow-Credentials", "true");
        responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        responseHeaders.set("Access-Control-Max-Age", "1209600");
        return responseHeaders;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorResponse e = new ErrorResponse();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        e.setTimestamp(ts.getTime());
        e.setStatus(HttpStatus.BAD_REQUEST.value());
        e.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        e.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList()).toString());
        return e;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(PharmacyRestException.class)
    public ErrorResponse handleValidationExceptions(Exception ex) {
        ErrorResponse e = new ErrorResponse();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        e.setTimestamp(ts.getTime());
        e.setStatus(HttpStatus.CONFLICT.value());
        e.setError(HttpStatus.CONFLICT.getReasonPhrase());
        e.setMessage(ex.getMessage());
        return e;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(PharmacyException.class)
    public ErrorResponse handleValidationExceptions(PharmacyException ex) {
        ErrorResponse e = new ErrorResponse();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        e.setTimestamp(ts.getTime());
        e.setStatus(HttpStatus.UNAUTHORIZED.value());
        e.setError(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        e.setMessage(ex.getMessage());
        return e;
    }
}
