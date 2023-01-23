package com.nimko.shppmentorpracktic7.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorMessage {
    private LocalDateTime timestamp;
    private String error;
    private String message;

}
