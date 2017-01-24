package com.orange.spellchecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rnuka on 10/26/15.
 */
public class Dictionary {
    Map<String,Integer> wordList = new TreeMap<String,Integer>();
    public Dictionary(File filePath){
        try {
            FileReader fReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fReader);
            String word = null;
            while((word = br.readLine() ) != null){
                wordList.put(word,1);
            }
        }catch(Exception e){

        }
    }

    public static void main(String[] args){
        File filePath = new File("/Users/rnuka/Desktop/Dictionary2.txt");
        Dictionary d = new Dictionary(filePath);
        for(Map.Entry<String, Integer> word : d.wordList.entrySet()){
            System.out.println(word.getKey()+" : "+word.getValue());
        }
    }



}
