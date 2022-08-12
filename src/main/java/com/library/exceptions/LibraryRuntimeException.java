package com.library.exceptions;

public class LibraryRuntimeException extends RuntimeException{
    public LibraryRuntimeException() {
    }

    public LibraryRuntimeException(String message) {
        super(message);
    }

    public LibraryRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryRuntimeException(Throwable cause) {
        super(cause);
    }
}
