package com.fun.abm.LargeFileMedianCalculator;


import com.fun.abm.LargeFileMedianCalculator.reader.BigFileReader;

import java.io.IOException;
import java.math.BigDecimal;

public class MedianCalculator {

    private final long start;
    private final long end;
    private BigFileReader bigFileReader;
    private FileCounterIterator counterIterator;

    public MedianCalculator(String fileName, long start, long end ) throws IOException {
        this.bigFileReader = new BigFileReader(fileName);
        initializeFileCounterIterator(fileName, start);
        this.start = start;
        this.end = end;
    }

    private void initializeFileCounterIterator(String fileName, long start) throws IOException {
        this.counterIterator = new FileCounterIterator(fileName);
        this.counterIterator.seek(start);
    }

    BigDecimal computeMedian() throws IOException {

        String s;
        BigDecimal sum = BigDecimal.valueOf(0);
        int loopCount = 0;


        while ( counterIterator.position() < end ) {
            s = counterIterator.readLine();
            if ( s == null)
                break;
            System.out.println("value read = " + s);
            sum = sum.add(BigDecimal.valueOf(Long.parseLong(s)));
            loopCount++;
        }

        System.out.println("Total no of numbers processed  = " + loopCount);
        if (loopCount > 0) {

            System.out.println("Sum = " + sum);
            BigDecimal numberOfIntegers = BigDecimal.valueOf(loopCount);
            BigDecimal divide = sum.divide(numberOfIntegers, 2, BigDecimal.ROUND_HALF_UP);

            System.out.println("divide = " + divide.floatValue());

            return divide;
        } else
            return  BigDecimal.valueOf(0);
    }
}
