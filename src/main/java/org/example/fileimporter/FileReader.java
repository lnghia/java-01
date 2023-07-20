package org.example.fileimporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {
    private static final FileReader instance;

    static {
        instance = new FileReader();
    }

    public static FileReader getInstance() {
        return instance;
    }

    public Stream<String> readFile(String filePath) throws IOException {
        return Files.lines(Path.of(filePath));
    }
}
