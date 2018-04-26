package com.fun.abm.LargeFileMedianCalculator;


import java.io.FileNotFoundException;
import java.math.BigInteger;

public class LargeFileMedianCalculatorApplication {

    public static void main(String[] args) {

        try {

            MedianCalculator medianCalculator = new MedianCalculator("data.txt");
            BigInteger median = medianCalculator.computeMedian();
            System.out.println("Median of the list of the files := " + median);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
