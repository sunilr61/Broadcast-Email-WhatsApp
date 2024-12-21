package com.example.college.exceptions;

public class UnAuthorizedAccessException extends Exception{
    public UnAuthorizedAccessException(String message) {
        super(message);
    }
}
