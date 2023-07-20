package org.example.exception;

public class NoCorrespondingMapperForFileExtension extends RuntimeException {
    public NoCorrespondingMapperForFileExtension(String errorMessage) {
        super(errorMessage);
    }
}
