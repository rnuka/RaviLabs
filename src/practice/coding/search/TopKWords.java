package practice.coding.search;

import java.util.List;
import java.util.Map;

/*
Given a list of input Strings, return top K words in the list.
 */
//TODO : Code incomplete
public class TopKWords {

    public List<Map.Entry<String,Integer>> kTopOccurences(List<String> input, int k){
        /*Map<String, Integer> wordsWithCounts = input.stream()
                                                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));*/
        List<Map.Entry<String,Integer>> results = null;
                /*wordsWithCounts.entrySet().stream()
                                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                    .limit(k)
                                    .collect(Collectors.toList());*/
        return results;


    }
}
