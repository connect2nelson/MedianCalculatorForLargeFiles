package com.fun.abm.LargeFileMedianCalculator.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BigFileReader {

    private String filename;

    private static Scanner scanner;

    public BigFileReader(String filename) throws IOException {
        this.filename = filename;
        initialize();

    }

    private void initialize() throws IOException {
        File file = new File(this.filename);

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
