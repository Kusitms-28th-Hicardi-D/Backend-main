package com.example.hicardi.domain.intro.exception;

import com.example.hicardi.global.response.ErrorMessage;

public class IntroNotFoundException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public IntroNotFoundException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
