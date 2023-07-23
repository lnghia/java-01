package org.example.fileimporter;

import java.util.stream.Stream;
import org.example.entity.Company;
import org.example.exception.NoCorrespondingMapperForFileExtensionException;
import org.example.mapper.Mapper;
import org.example.mapper.MapperFactory;
import org.example.util.FileUtils;
import org.example.util.Overwatch;

public class FileProcessor {
  private FileProcessor() {}

  public static Stream<Company> process() {
    String filePath = Overwatch.getInstance().getFilePath();
    Stream<String> lines = FileReader.readFile(filePath);
    String fileExtension = FileUtils.getExtensionByStringHandling(filePath).orElse("");
    Mapper mapper;

    try {
      mapper = MapperFactory.getMapper(fileExtension);
    } catch (NoCorrespondingMapperForFileExtensionException exception) {
      exception.printStackTrace();

      return Stream.empty();
    }

    return lines.skip(1).map(mapper::lineToCompany);
  }
}
