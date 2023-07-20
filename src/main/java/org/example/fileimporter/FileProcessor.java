package org.example.fileimporter;

import org.example.Entity.Company;
import org.example.mapper.Mapper;
import org.example.mapper.MapperFactory;

import java.io.IOException;
import java.util.stream.Stream;

public class FileProcessor {
    public Stream<Company> process(String filePath, String fileExtension) throws IOException {
        Stream<String> lines = FileReader.getInstance().readFile(filePath);

        Mapper mapper = MapperFactory.getMapper(fileExtension);

        return lines.map(String::trim).map(mapper::lineToCompany);
    }
}
