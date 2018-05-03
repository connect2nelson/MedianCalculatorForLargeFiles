package com.fun.abm.LargeFileMedianCalculator;

import java.io.*;

public class FileCounterIterator {

    public Long position() {
        return _position;
    }

    public Long fileSize() {
        return _fileSize;
    }

    public FileCounterIterator newlineLength(Long newNewlineLength) {
        this._newlineLength = newNewlineLength;
        return this;
    }

    private Long _fileSize = 0L;
    private Long _position = 0L;
    private Long _newlineLength = 1L;
    private RandomAccessFile fp;
    private BufferedReader itr;

    public FileCounterIterator(String filename) throws IOException {
        fp = new RandomAccessFile(filename, "r");
        _fileSize = fp.length();
        this.seek(0L);
    }

    public FileCounterIterator seek(Long newPosition) throws IOException {
        this.fp.seek(newPosition);
        this._position = newPosition;
        itr = new BufferedReader(new InputStreamReader(new FileInputStream(fp.getFD())));
        return this;
    }

    public Boolean hasNext() throws IOException {
        return this._position < this._fileSize;
    }

    public String readLine() throws IOException {
        String nextLine = itr.readLine();
        if ( nextLine == null)
            return null;
        this._position += nextLine.getBytes().length + _newlineLength;
        return nextLine;
    }
}