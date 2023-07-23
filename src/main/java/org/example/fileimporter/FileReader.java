package org.example.fileimporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import lombok.Getter;

@Getter
public class FileReader {

  private FileReader() {}

  public static Stream<String> readFile(String filePath) {
    try {
      return Files.lines(Paths.get(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return Stream.empty();
  }
}
