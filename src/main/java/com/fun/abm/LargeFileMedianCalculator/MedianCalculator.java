package com.fun.abm.LargeFileMedianCalculator;


import com.fun.abm.LargeFileMedianCalculator.reader.BigFileReader;

import java.io.IOException;
import java.math.BigInteger;

public class MedianCalculator {

    private BigFileReader bigFileReader;

    MedianCalculator(String filePath) throws IOException {
        bigFileReader = new BigFileReader(filePath);
    }

    BigInteger computeMedian() {

        String s;
        BigInteger sum = BigInteger.valueOf(0);
        int loopCount = 0;

        while ((s = bigFileReader.readALine()) != null) {
            sum = sum.add(BigInteger.valueOf(Long.parseLong(s)));
            loopCount++;
        }

        if (loopCount > 0) {
            return sum.divide(BigInteger.valueOf(loopCount));
        }

        return BigInteger.valueOf(0);
    }
}
