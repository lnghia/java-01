package org.example.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.example.entity.Company;
import org.example.fileimporter.FileProcessor;

public class CompanyService implements Service {

    private static final Predicate<Company> isHeadQuarterPredicate = Company::isHeadQuarter;

    private static Predicate<Company> isInCountryPredicate(String country) {
        return company -> company.getCountry().equals(country);
    }

    public void calTotalCapitalIsHeadQuarterWithCountryIn(String country) {
        Stream<Company> companyStream = FileProcessor.process();

        long result =
                companyStream
                        .filter(isHeadQuarterPredicate)
                        .filter(isInCountryPredicate(country))
                        .map(Company::getCapital)
                        .reduce(0, Integer::sum);

        companyStream.close();

        System.out.println(result);
    }

    public void printOutCompaniesInCountry(String country) {
        Stream<Company> companyStream = FileProcessor.process();

        List<String> result =
                companyStream
                        .filter(isInCountryPredicate(country))
                        .map(Company::getName)
                        .collect(Collectors.toList());

        companyStream.close();

        System.out.println(result);
    }
}
