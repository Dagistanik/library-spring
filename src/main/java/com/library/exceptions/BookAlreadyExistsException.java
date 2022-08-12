package com.library.exceptions;

public class BookAlreadyExistsException extends LibraryRuntimeException {

    public BookAlreadyExistsException(String message){
        super(message);
    }

}
