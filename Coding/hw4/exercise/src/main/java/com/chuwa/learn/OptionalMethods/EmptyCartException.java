package com.chuwa.learn.OptionalMethods;


public class EmptyCartException extends RuntimeException {
    public EmptyCartException(String message) {
        super(message);
    }
}
