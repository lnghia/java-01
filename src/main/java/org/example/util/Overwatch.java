package org.example.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Overwatch {
  private static final Overwatch instance;

  private String filePath;

  private String fileExtension;

  private String importDirectoryPath = "C:/Users/ledn/Documents/import";

  static {
    instance = new Overwatch();
  }

  public static Overwatch getInstance() {
    return instance;
  }
}
