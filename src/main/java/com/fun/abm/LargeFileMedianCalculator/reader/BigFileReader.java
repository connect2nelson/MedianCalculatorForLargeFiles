package com.fun.abm.LargeFileMedianCalculator.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class BigFileReader {

    private String filename;

    private static Scanner scanner;

    public BigFileReader(String filename) throws IOException {
        this.filename = filename;
        initialize();

    }

    private void initialize() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader
                .getResource(filename);

        if (resource == null)
            throw new FileNotFoundException();

        File file = new File(resource.getFile());

        FileInputStream inputStream = new FileInputStream(file);
        scanner = new Scanner(inputStream, "UTF-8");
    }


    public String readALine() {

        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }

}
