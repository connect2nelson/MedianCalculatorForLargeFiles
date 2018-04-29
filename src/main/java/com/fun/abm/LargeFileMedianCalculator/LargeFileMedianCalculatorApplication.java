package com.fun.abm.LargeFileMedianCalculator;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class LargeFileMedianCalculatorApplication {

    public static void main(String[] args) {

        try {
            MedianCalculatorExecutorService medianCalculatorExecutorService = new MedianCalculatorExecutorService();
            medianCalculatorExecutorService.start();

            MedianCalculator medianCalculator = new MedianCalculator("data.txt");
            BigInteger median = medianCalculator.computeMedian();
            System.out.println("Median of the list of the files := " + median);
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
    }
}
