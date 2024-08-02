package com.fresh.coding.springweb.handlers;

import com.fresh.coding.springweb.exceptions.HttpBadRequestException;
import com.fresh.coding.springweb.exceptions.HttpNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppRestControllerAdvice {

    @ExceptionHandler(HttpNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody AppError<String> handleNotFoundException(HttpNotFoundException ex) {
        return new AppError<>(ex.getMessage(), LocalDate.now(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(HttpBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody AppError<String> handleBadRequestException(HttpBadRequestException ex) {
        return new AppError<>(ex.getMessage(), LocalDate.now(), HttpStatus.BAD_REQUEST.value());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody AppError<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                errors.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        return new AppError<>(errors, LocalDate.now(), HttpStatus.BAD_REQUEST.value());
    }
}
