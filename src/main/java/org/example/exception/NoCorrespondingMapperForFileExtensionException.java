package org.example.exception;

public class NoCorrespondingMapperForFileExtensionException extends RuntimeException {
    public NoCorrespondingMapperForFileExtensionException(String errorMessage) {
        super(errorMessage);
    }
}
