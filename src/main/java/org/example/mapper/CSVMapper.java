package org.example.mapper;

import org.example.entity.Company;
import org.example.util.Constant;
import org.example.util.Converter;

public class CSVMapper implements Mapper {
  @Override
  public Company lineToCompany(String line) {
    String[] cols = line.split(Constant.CSV_SEPARATOR);

    return Company.builder()
        .id(Integer.parseInt(cols[0]))
        .name(cols[1])
        .foundation(cols[2])
        .capital(Integer.parseInt(cols[3]))
        .country(cols[4])
        .isHeadQuarter(
            Converter.binaryInStringToBoolean(
                cols.length == Constant.COL_NUM ? cols[5] : Constant.ZERO))
        .build();
  }
}
