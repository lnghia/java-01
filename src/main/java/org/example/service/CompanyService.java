package org.example.service;

import java.util.List;
import java.util.stream.Stream;
import org.example.entity.Company;
import org.example.fileimporter.FileProcessor;

// @Slf4j
public class CompanyService {

  public void calTotalCapitalIsHeadQuarterWithCountryIn(String country) {
    Stream<Company> companyStream = FileProcessor.process();

    long result =
        companyStream
            .filter(Company::isHeadQuarter)
            .filter(company -> company.getCountry().equals(country))
            .map(Company::getCapital)
            .reduce(0, Integer::sum);
    companyStream.close();

    System.out.println(result);
  }

  public void printOutCompaniesInCountry(String country) {
    Stream<Company> companyStream = FileProcessor.process();

    List<String> result =
        companyStream
            .filter(company -> company.getCountry().equals(country))
            .map(Company::getName)
            .toList();
    companyStream.close();

    System.out.println(result);
  }
}
