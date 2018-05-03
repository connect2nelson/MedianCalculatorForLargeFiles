package com.fun.abm.LargeFileMedianCalculator;


import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class LargeFileMedianCalculatorApplication {

    public static void main(String[] args) {

        try {
            MedianCalculatorExecutorService medianCalculatorExecutorService = new MedianCalculatorExecutorService();
            medianCalculatorExecutorService.start();

        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
    }
}
