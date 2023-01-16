package com.example.mngkw_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InstructorsNotFoundException extends RuntimeException {
    public InstructorsNotFoundException(String message){ super(message); }
}
