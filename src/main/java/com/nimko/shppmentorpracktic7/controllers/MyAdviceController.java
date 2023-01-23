package com.nimko.shppmentorpracktic7.controllers;

import com.nimko.shppmentorpracktic7.dto.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class MyAdviceController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> processValidationError(MethodArgumentNotValidException ex) {
        String mess = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()).toString();
        ErrorMessage message = new ErrorMessage(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),"Error validate ToDo", mess);
        return ResponseEntity
                .badRequest()
                .body(message);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> notFoundError(NoSuchElementException exception) {
        String mess = exception.getMessage();
        log.error(mess);
        ErrorMessage message = new ErrorMessage(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(),"Error create or update ToDo", mess);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

}

