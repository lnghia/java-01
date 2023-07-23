package org.example.fileimporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

import lombok.Getter;
import org.example.util.OverWatch;

@Getter
public class FileReader {

    private FileReader() {
    }

    public static final Supplier<Stream<String>> companiesSupplier = () -> readFile(OverWatch.getInstance().getFilePath());

    public static Stream<String> readFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Stream.empty();
    }
}
