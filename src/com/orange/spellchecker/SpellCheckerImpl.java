package com.orange.spellchecker;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rnuka on 10/24/15.
 */
public class SpellCheckerImpl implements SpellChecker {


    private List<String> spellCheckWord(String s){
        List<String> suggestions = new ArrayList<String>();
        Map<String, Integer> suggestionMap = new HashMap<String, Integer>();
        int finalMinEdit = s.length()-1;

        try {
            File filePath = new File("/Users/rnuka/Desktop/Dictionary.txt");
            Dictionary d = new Dictionary(filePath);

            //check if exact match
            if(d.wordList.keySet().contains(s)){
                return suggestions;
            }

            //if no exact match found, loop through each dictionary word and find edit lengths
            for(String word: d.wordList.keySet()){
                MinimumEdits me = new MinimumEdits(s, word);
                int minEdit = me.minimumEdit(s, word);
                //System.out.println("minimum edit for "+s+" and "+word+" is"+minEdit);
                suggestionMap.put(word, minEdit);
                if(minEdit < finalMinEdit){
                    finalMinEdit = minEdit;
                }
            }

            //return the strings with lowest number of edits
            for(Map.Entry<String, Integer> word: suggestionMap.entrySet()){
                if(word.getValue() == finalMinEdit){
                    suggestions.add(word.getKey());
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return suggestions;

    }




    @Override
    public Map<String, List<String>> spellCheck(String s){

        Map<String, List<String>> suggestionList = new HashMap<String, List<String>>();
        for(String word: s.replaceAll("\\s+"," ").split(" ")){
            if(suggestionList.get(word) == null) {
                List<String> suggestions = spellCheckWord(word);
                suggestionList.put(word, suggestions);
            }
        }

        return suggestionList;
    }


    //test
    public static void main(String[] args){
        SpellCheckerImpl sci = new SpellCheckerImpl();
        long startTime = System.currentTimeMillis();
        Map<String, List<String>> suggestionList = sci.spellCheck("aple is a good bayd. dranzk is going to be paznful anb yef sucessful.");
        for(Map.Entry<String, List<String>> wordList : suggestionList.entrySet()){
            for(String word : wordList.getValue()){
                System.out.println("suggestion for "+wordList.getKey()+" :: "+word);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("execution time="+(endTime-startTime)+" milli seconds");
    }


}
