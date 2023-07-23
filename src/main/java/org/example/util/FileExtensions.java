package org.example.util;

public enum FileExtensions {
  CSV("csv"),
  ;

  public final String value;

  FileExtensions(String value) {
    this.value = value;
  }
}
