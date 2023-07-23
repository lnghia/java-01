package org.example.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OverWatch {
    private static final OverWatch instance;

    private String filePath;

    private String fileExtension;

    private String importDirectoryPath = "C:/Users/ledn/Documents/import";

    static {
        instance = new OverWatch();
    }

    public static OverWatch getInstance() {
        return instance;
    }
}
