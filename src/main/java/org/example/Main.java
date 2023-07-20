package org.example;

import org.example.fileimporter.FileProcessor;
import org.example.service.CompanyService;

public class Main {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        CompanyService service = new CompanyService(fileProcessor);

        service.countCapitalIsHeadQuarterWithCountryIn("CH");
    }
}