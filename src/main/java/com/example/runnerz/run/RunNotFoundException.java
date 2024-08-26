package com.example.runnerz.run;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(String message) {
        super(message);
    }
}
