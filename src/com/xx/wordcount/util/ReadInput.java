package com.xx.wordcount.util;

import java.io.*;

/**
 * Created by rnuka on 8/24/16.
 */
public class ReadInput {


    public String readFromStream() throws FileNotFoundException, IOException
    {
        InputStream in = new FileInputStream(new File("C:/temp/test.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        System.out.println(out.toString());   //Prints the string content read from input stream
        reader.close();
        return out.toString();
    }
}
