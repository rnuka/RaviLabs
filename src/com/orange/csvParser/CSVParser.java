package com.orange.csvParser;

import java.io.*;
import java.net.URL;
import java.util.Iterator;

/**
 * Created by rnuka on 7/2/16.
 */
public final class CSVParser implements Iterable<CSVRecord>, Closeable {

    //Instance Variables
    LexicalAnalyzer lexer;

    //public Constructor-1
    public  CSVParser(String csvString, char delimiter){
        this(new StringReader(csvString), delimiter);
    }

    //public Constructor-2
    public CSVParser(URL csvUrl, char delimiter) throws IOException{
        this(new InputStreamReader(csvUrl.openStream()), delimiter);
    }

    //private constructor
    private CSVParser(Reader reader, char delimiter){
      this.lexer  = new LexicalAnalyzer(new ExtendedBufferedReader(reader), delimiter);
    }

    @Override
    public Iterator<CSVRecord> iterator() {
       return new Iterator<CSVRecord>(){
            private CSVRecord current;
            @Override
            public CSVRecord next(){

                return new CSVRecord();
            }

            @Override
            public boolean hasNext(){
                if(this.current == null){
                    this.current = this.next();
                }
                return this.current != null;
            }
        };
    }

    public CSVRecord nextRecord(){
        CSVRecord result = null;
       return result;
    }



    @Override
    public void close(){

    }
}
