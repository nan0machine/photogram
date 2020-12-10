package com.example.photogram.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NullEntityReferenceException extends RuntimeException {
    public NullEntityReferenceException(String message) {
        super(message);
    }
}
