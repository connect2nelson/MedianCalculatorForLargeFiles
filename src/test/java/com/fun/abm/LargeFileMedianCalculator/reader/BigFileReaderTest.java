package com.fun.abm.LargeFileMedianCalculator.reader;


import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class BigFileReaderTest {

    @Test
    public void shouldCreateABigFileReaderObjectForAGivenFileName() {

        try {
            BigFileReader bigFileReader = new BigFileReader("test-data.txt");
        } catch (IOException e) {
            fail();
        }

    }

    @Test
    public void shouldNotCreateABigFileReaderObjectIfTheFileToBeReadDoesNotExist() {

        try {
            BigFileReader bigFileReader = new BigFileReader("non-existent.txt");
            fail();
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void shouldBeAbleToReadALineFromTheFile() throws IOException {

        BigFileReader bigFileReader = new BigFileReader("test-data.txt");
        String firstLine = bigFileReader.readALine();

        assertThat(firstLine).isEqualTo("1");
    }

    @Test
    public void shouldBeAbleToReadMoreThanASingleLineFromTheFile() throws IOException {

        BigFileReader bigFileReader = new BigFileReader("test-data.txt");
        bigFileReader.readALine();
        String secondLine = bigFileReader.readALine();

        assertThat(secondLine).isEqualTo("2");
    }

    @Test
    public void shouldStopReadingFromAFileOnceThereAreNoMoreLines() throws IOException {

        BigFileReader bigFileReader = new BigFileReader("test-data.txt");
        while ( bigFileReader.readALine() != null);

        assertThat(bigFileReader.readALine()).isEqualTo(null);
    }
}