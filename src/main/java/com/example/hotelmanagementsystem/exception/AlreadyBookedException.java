package com.example.hotelmanagementsystem.exception;

public class AlreadyBookedException extends RuntimeException{
    public AlreadyBookedException(String message) {
        super(message);
    }
}
