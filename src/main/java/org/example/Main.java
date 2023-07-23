package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

import org.example.dirwatcher.WatchDir;
import org.example.service.CompanyService;
import org.example.util.OverWatch;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        CompanyService service = new CompanyService();

        System.out.println("Input file path: ");
        OverWatch.getInstance().setFilePath(scanner.nextLine());

        service.calTotalCapitalIsHeadQuarterWithCountryIn("CH");
        service.printOutCompaniesInCountry("CH");

        new WatchDir(Paths.get(OverWatch.getInstance().getImportDirectoryPath()))
                .processEvents(() -> {
                    service.calTotalCapitalIsHeadQuarterWithCountryIn("CH");
                    service.printOutCompaniesInCountry("CH");
                });
    }
}
