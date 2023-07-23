package org.example;

import static java.nio.file.StandardWatchEventKinds.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import org.example.dirwatcher.WatchDir;
import org.example.service.CompanyService;
import org.example.util.Overwatch;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    CompanyService service = new CompanyService();

    System.out.println("Input file path: ");
    Overwatch.getInstance().setFilePath(scanner.nextLine());

    service.calTotalCapitalIsHeadQuarterWithCountryIn("CH");
    service.printOutCompaniesInCountry("CH");

    new WatchDir(Paths.get(Overwatch.getInstance().getImportDirectoryPath()), false)
        .processEvents();
  }
}
