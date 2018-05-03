package com.fun.abm.LargeFileMedianCalculator;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicFileOffsetCounter {

    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }
}
