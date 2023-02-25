package com.nimko.shppmentorpracktic7.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorMessage {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;

}
