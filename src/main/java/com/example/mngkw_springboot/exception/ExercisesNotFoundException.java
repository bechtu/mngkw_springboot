package com.example.mngkw_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExercisesNotFoundException extends RuntimeException {
    public ExercisesNotFoundException(String message){ super(message); }
}
