package org.example.exception;

public class ImportMustBeAFileException extends RuntimeException {
    public ImportMustBeAFileException(String errorMessage) {
        super(errorMessage);
    }
}
