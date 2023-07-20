package mapper;

import Entity.Company;
import util.Converter;

public class CSVMapper implements Mapper {
    @Override
    public Company lineToCompany(String line) {
        String[] cols = line.split(",");

        return Company
                .builder()
                .id(Integer.parseInt(cols[0]))
                .country(cols[1])
                .isHeadQuarter(Converter.getInstance().binaryInStringToBoolean(cols[2]))
                .build();
    }
}
