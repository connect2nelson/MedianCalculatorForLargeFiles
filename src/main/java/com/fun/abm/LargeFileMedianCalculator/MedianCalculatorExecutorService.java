package com.fun.abm.LargeFileMedianCalculator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MedianCalculatorExecutorService {

    private Path numbersFilePath;


    public long getFileSize() throws IOException {
         numbersFilePath = Paths.get("src/main/resources/numbers.txt");
        FileChannel imageFileChannel = FileChannel.open(numbersFilePath);

        return imageFileChannel.size();
    }

    public void start() throws InterruptedException, ExecutionException, IOException {

        ExecutorService executorService = new ThreadPoolExecutor(1,
                4,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        List<Callable<String>> callableTasks = new ArrayList<>();


        long fileSize = getFileSize();
        long discreetFileSize =  fileSize /4 ;

        System.out.println("discreetFileSize = " + discreetFileSize);

        long start = 0, end = fileSize;
        long currentStart = start;

        do {

            long finalCurrentStart = currentStart;
            Callable<String> callableTask = () -> {

                MedianCalculator medianCalculator = new MedianCalculator(numbersFilePath.toAbsolutePath().toString(),
                        finalCurrentStart, finalCurrentStart + discreetFileSize);

                BigDecimal median = medianCalculator.computeMedian();

                return median.toString();
            };
            callableTasks.add(callableTask);

            System.out.println("currentStart = " + currentStart);
            currentStart += discreetFileSize;
            System.out.println("new current start  = " + currentStart);

        }while ( currentStart < end);


        List<Future<String>> futures = executorService.invokeAll(callableTasks);

        for ( Future future : futures) {
            System.out.println("future.get() = " + future.get());
        }
    }
}
