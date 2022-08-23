package com.ayo.conversion.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private String message;
    private LocalDateTime dateTime;
}
