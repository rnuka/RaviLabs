package com.orange.csvParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by rnuka on 7/2/16.
 */
public class ExtendedBufferedReader extends BufferedReader {
    //Constructor
    ExtendedBufferedReader(final Reader reader) {
        super(reader);
    }

    @Override
    public int read(final char[] buf, final int offset, final int length) throws IOException{
        if (length == 0) {
            return 0;
        }

        final int len = super.read(buf, offset, length);


        return len;
    }

    public void close(){

    }
}
