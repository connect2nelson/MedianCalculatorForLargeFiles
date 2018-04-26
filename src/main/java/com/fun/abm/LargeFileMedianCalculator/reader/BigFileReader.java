package com.fun.abm.LargeFileMedianCalculator.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BigFileReader {

    private String filename;

    private static Scanner scanner;

    public BigFileReader(String filename) throws FileNotFoundException {
        this.filename = filename;
        initialize();

    }

    private void initialize() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader
                .getResource(filename)
                .getFile());

        FileInputStream inputStream = new FileInputStream(file);
        scanner = new Scanner(inputStream, "UTF-8");
    }


    public String readALine(){

        if( scanner.hasNextLine()){
            return scanner.nextLine();
        }
        return null;
    }

}
