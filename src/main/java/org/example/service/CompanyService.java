package org.example.service;

import org.example.Entity.Company;
import org.example.fileimporter.FileProcessor;

import java.io.IOException;
import java.util.stream.Stream;

public class CompanyService {
    private final FileProcessor fileProcessor;

    public CompanyService(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    public void countCapitalIsHeadQuarterWithCountryIn(String country) {
        try {
            Stream<Company> companyStream = fileProcessor.process("", "csv");
            long result = companyStream
                    .filter(Company::isHeadQuarter)
                    .filter(company -> company.getCountry().equals("CH"))
                    .count();

            System.out.println(result);
        } catch (IOException e) {
            System.out.println("There has been an error in an attempt to read file");
        }
    }
}
