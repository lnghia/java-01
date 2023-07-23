package org.example.mapper;

import org.example.exception.NoCorrespondingMapperForFileExtensionException;
import org.example.util.ExMessage;

public class MapperFactory {

    private MapperFactory() {
    }

    public static Mapper getMapper(String fileExtension)
            throws NoCorrespondingMapperForFileExtensionException {
        if (fileExtension.equals("csv")) {
            return new CSVMapper();
        }

        throw new NoCorrespondingMapperForFileExtensionException(
                String.format(ExMessage.NO_MAPPER_FOUND_FOR_FILE_TYPE, fileExtension));
    }
}
