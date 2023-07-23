package org.example.util;

public class Converter {

  private Converter() {}

  public static boolean binaryInStringToBoolean(String data) {
    return !data.isEmpty() && !data.equals(Constant.ZERO);
  }
}
