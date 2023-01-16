package com.example.mngkw_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CampsNotFoundException extends RuntimeException {
    public CampsNotFoundException(String message){ super(message); }
}
