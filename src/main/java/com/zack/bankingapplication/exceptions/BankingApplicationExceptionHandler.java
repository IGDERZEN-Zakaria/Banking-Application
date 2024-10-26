package com.zack.bankingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BankingApplicationExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                null);

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse();
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(source -> source.getField() + " : " + source.getDefaultMessage()).collect(Collectors.toList());
        message.setStatusCode(HttpStatus.BAD_REQUEST.value());
        message.setMessage("Field validation errors");
        message.setTimestamp(new Date());
        message.setFieldErrors(errors);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NotAllowedException.class)
    public ResponseEntity<ErrorResponse> notAllowedExceptionHandler(NotAllowedException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                null);

        return new ResponseEntity<>(message, HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestExceptionHandler(BadRequestException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                null);

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}