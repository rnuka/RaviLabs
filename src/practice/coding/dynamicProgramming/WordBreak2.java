package practice.coding.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Question: In previous problem of wordbreak, it returns true or false but doesn't return the actual
words in dictionary that formed the sentence.

Write a program to give the words that formed the sentence and the number of words forming the sentence
shoudl be minimal

example:
input: "aisadog" and dictionary=["a","is","ais","dog"]

then two possible outputs are possible:
1. "a", "is","a","dog" (4 words)
2. "ais","a","dog" (3 words)

the program should return second output as it has minimal count of words and yet true word break.
 */
public class WordBreak2 {

    public List<String> shortestWordBreak(String input, Set<String> dictionary){

        int inputLength = input.length();
        int[][] dp = new int[inputLength+1][inputLength+1];

        List<String> results = new ArrayList<String>();

        //step-1: fill the dp table with max possible lengths
        for(int i=1; i<=inputLength; i++){

            //filler for unvisited columns in new row as j starts from i instead of 0
            for(int k=0; k<i; k++){
                dp[i][k] = dp[i-1][k];
            }
            //fill from diagnol to end
            for(int j=i; j<=inputLength; j++){
                String temp = input.substring(i-1, Math.min(j,inputLength));
                if(dictionary.contains(temp)){
                    dp[i][j]=Math.max(dp[i-1][j],temp.length());
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        //below for loop is optional to print dp table for debugging
        System.out.println("---filled dp to see table---");
        for(int i=0; i<=inputLength; i++){
            for(int j=0; j<=inputLength; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println("----");

        //step-2: Now traverse from last row last column to last row first and extract words
        for(int i= inputLength; i>0; ){
            int length = dp[inputLength][i];
            if(length > 0){
                String temp = input.substring((i-length),Math.min(inputLength,i));
                results.add(temp);
                i = i - length;
            }else{
                return null;
            }
        }

        return results;
    }

    public void testcase3(){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("a");
        dictionary.add("is");
        dictionary.add("ais");
        dictionary.add("dogy");

        String input = "aisadog";

        List<String> results = shortestWordBreak(input, dictionary);
        if(results != null) {
            for (String s : shortestWordBreak(input, dictionary)) {
                System.out.println(s);
            }
        }else{
            System.out.println("Unable to break the given input into valid words of dictionary");
        }
    }

    public void testcase2(){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("ab");
        dictionary.add("is");
        dictionary.add("aisd");
        dictionary.add("dog");

        String input = "aisadog";

        List<String> results = shortestWordBreak(input, dictionary);
        if(results != null) {
            for (String s : shortestWordBreak(input, dictionary)) {
                System.out.println(s);
            }
        }else{
            System.out.println("Unable to break the given input into valid words of dictionary");
        }
    }

    public void testcase1(){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("a");
        dictionary.add("is");
        dictionary.add("ais");
        dictionary.add("dog");

        String input = "aisadog";

        List<String> results = shortestWordBreak(input, dictionary);
        if(results != null) {
            System.out.println("output is::");
            for (String s : results) {
                System.out.println(s);
            }
        }else{
            System.out.println("Unable to break the given input into valid words of dictionary");
        }
    }

    public void testbed(){
        System.out.println("testcase1 begin *****");
        testcase1();
        System.out.println("\n\n");
        System.out.println("testcase2 begin *****");
        testcase2();
        System.out.println("\n\n");
        System.out.println("testcase3 begin *****");
        testcase3();
    }

    public static void main(String args[]){
        WordBreak2 w2 = new WordBreak2();
        w2.testbed();
    }

}
