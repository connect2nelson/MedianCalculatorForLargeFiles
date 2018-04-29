package com.fun.abm.LargeFileMedianCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MedianCalculatorExecutorService {

    public void start() throws InterruptedException, ExecutionException {

        ExecutorService executorService = new ThreadPoolExecutor(1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        Callable<String> callableTask = () -> {
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        List<Future<String>> futures = executorService.invokeAll(callableTasks);

        for ( Future future : futures) {
            System.out.println("future.get() = " + future.get());
        }
    }
}
