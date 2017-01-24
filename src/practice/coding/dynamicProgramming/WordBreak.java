package practice.coding.dynamicProgramming;

/*
Question Given an input string and a dictionary of words, find out if the input string can be
segmented into a space-separated sequence of dictionary words. See following examples for more details.
This is a famous Google interview question, also being asked by many other companies now a days.

Consider the following dictionary
dictionary = [ i, like, sam, sung, samsung, mobile, ice,
  cream, icecream, man, go, mango]

Example-1:
Input:  ilike
Output: Yes
The string can be segmented as "i like".

Example-2:
Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" or "i like sam sung".
 */

/*
Approach: say dict is dictionary and s is string
f(1) = true if dict contains s (substring(0) is in dictionary)
       false Otherwise
f(2) = true if f(1) is true & dict contains s.charAt(1) or
       true if substring(0,2) contains in dictionary.
       false otherwise
f(3) = true if f(2) is true and dict contains s.charAt(2) or
       true f(0)&&substring(0-3) or f(1)&&substring(1-3) or f(2)&&substring(2-3) ...
f(n) = true if      f(i) is true && (substring(i-n) contains in dictionary )
                   for all i:0->n
 */

import java.util.HashSet;
import java.util.Set;

public class WordBreak {


    //Using Recursion
    public boolean isValidWordBreak(String input, Set<String> dictionary){

        if(input==null || input.length()<=0){
            return false;
        }

        if(dictionary.contains(input)){
            return true;
        }
        boolean returnVal = false;
        for(int i=0; i<input.length(); i++){
            if(isValidWordBreak(input.substring(0,i),dictionary) &&
                    dictionary.contains(input.substring(i))){
                returnVal = true;
            }
        }

        return returnVal;
    }


    //Using DP2 using same recursive function logic with memoization
    public boolean isValidWordBreakDp2(String input, Set<String> dictionary){
        if(input==null || input.length()<=0){
            return false;
        }

        boolean[] dp = new boolean[input.length()+1];
        dp[0] = true;

        for(int i=0; i<input.length(); i++){ //solve n problems i.e. f(1), f(2)...f(n)
            String temp = input.substring(0,i+1); //solve subproblem string
            for(int j=0; j<temp.length(); j++){
                String temp2 = temp.substring(j);
                if(dp[j] && dictionary.contains(temp2) ){ //same as recursion logic
                    dp[temp.length()]=true;
                }
            }
        }
        return dp[input.length()];
    }


    //Using DP
    public boolean isValidWordBreakDp(String input, Set<String> dictionary){
        if(input==null || input.length()<=0){
            return false;
        }

        boolean[] dp = new boolean[input.length()+1];
        dp[0] = true;

        for(int i=0; i<input.length(); i++){ //solve n problems i.e. f(1), f(2)...f(n)
            for(int j=i+1; j<=input.length() && dp[i]; j++){
                String temp = input.substring(i,j);
                if(dictionary.contains(temp)){
                    dp[j]=true;
                }
            }
        }
        return dp[input.length()];
    }




    public void testcase2(){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("a");
        dictionary.add("is");
        dictionary.add("ais");
        dictionary.add("dog");

        String input = "aisadog";
        System.out.println("Using DP, For input::"+input+", is valid word breaks possible? ::"
                +isValidWordBreakDp2(input, dictionary));

    }

    public void testcase1(){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("a");
        dictionary.add("is");
        dictionary.add("ais");
        dictionary.add("dog");

        String input = "aisadog";
        System.out.println("For input::"+input+", is valid word breaks possible? ::"+isValidWordBreak(input, dictionary));

    }

    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String args[]){
        WordBreak w = new WordBreak();
        w.testbed();
    }

}
