package com.danik.bookstore.exception;

public class InvalidBookDataException extends LibraryRuntimeException{
    public InvalidBookDataException(String message){
        super(message);
    }
}
