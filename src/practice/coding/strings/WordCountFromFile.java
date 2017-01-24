package practice.coding.strings;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;

public class WordCountFromFile {
    public WordCountFromFile() {
    }

    public Map<String,Integer> wordCount( String filePath){
        FileInputStream fs;
        DataInputStream ds;
        HashMap<String, Integer> hm = new HashMap<String,Integer>();

        try{
            fs = new FileInputStream(filePath);
            ds = new DataInputStream(fs);
            BufferedReader br = new BufferedReader(new InputStreamReader(ds));
            String line = null;

            while((line = br.readLine())!=null){
                for(String temp : line.split(" ")){
                    if(hm.get(temp) != null){
                        int count = hm.get(temp);
                        hm.put(temp,count+1);
                    }else{
                        hm.put(temp,1);
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return hm;

    }

    public static void main(String args[]){

        String filePath = "/Users/rnuka/temp.txt";
        Map<String, Integer> hm;

        WordCountFromFile wcf = new WordCountFromFile();

        hm = wcf.wordCount(filePath);

        for(Map.Entry<String,Integer> iter :hm.entrySet()){
            System.out.println(iter.getKey()+" count is "+iter.getValue());
        }


        
    }
}
