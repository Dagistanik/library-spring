package com.danik.bookstore.exception;

public class BookAlreadyExistsException extends LibraryRuntimeException {

    public BookAlreadyExistsException(String message){
        super(message);
    }

}
