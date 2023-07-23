package org.example.util;

import java.util.Optional;

public class FileUtils {

    private FileUtils() {
    }

    public static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains(Constant.FILE_EXTENSION_SEPARATOR))
                .map(f -> f.substring(filename.lastIndexOf(Constant.FILE_EXTENSION_SEPARATOR) + 1));
    }
}
