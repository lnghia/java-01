package mapper;

import exception.NoCorrespondingMapperForFileExtension;

public class MapperFactory {
    public static Mapper getMapper(String fileExtension) {
        if (fileExtension.equals("csv")) {
            return new CSVMapper();
        }

        throw new NoCorrespondingMapperForFileExtension("No corresponding mapper found for file type " + fileExtension);
    }
}
