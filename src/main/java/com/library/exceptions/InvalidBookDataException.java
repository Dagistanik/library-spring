package com.library.exceptions;

public class InvalidBookDataException extends LibraryRuntimeException{
    public InvalidBookDataException(String message){
        super(message);
    }
}
