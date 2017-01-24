package practice.coding.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rnuka on 6/9/16.
 */
/*
* Given list of strings, return pair of strings when concatenated will form a palindrome
* */
public class PalindromeStrings {

    public Map<String,String> getPalindromes(String[] sarray){
        Map<String,String> checkList = new HashMap<String,String>();
        Map<String,String> results = new HashMap<String,String>();

        for(String s: sarray){

            String reverse = new StringBuilder(s).reverse().toString();
            String reverseOneMinus = reverse.substring(1);

            if (!checkList.containsKey(s)) {

                checkList.put(reverse, s);
                checkList.put(reverseOneMinus, s);


                //if end characters are repeating
                int length = reverse.length();
                for(int i=1 ;i<length-1 && reverse.charAt(i) == reverse.charAt(0) ; i++) {
                    String subString = reverse.substring(i);
                    checkList.put(subString, s);
                }


                //if beginning characters are repeating
                for(int i=0 ;i<length-1 && s.charAt(i) == s.charAt(0) ; i++) {
                    String subString = new StringBuilder(s.substring(i+1)).reverse().toString();
                    System.out.println("adding subString="+subString+" and s="+s);
                    checkList.put(subString, s);
                }
            } else {
                results.put(s, checkList.get(s));
            }
        }

        for(Map.Entry e: results.entrySet()){
            System.out.println("pair::"+e.getKey()+", "+e.getValue());
        }

        return results;
    }

    public void myassert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert fails");
        }
    }

    /**DO NOT Change inputs instead create testbasic3 */
    public void testbasic2(){
        String[] input = {"abc","cba","aabc","cb","bbate","eta","apple","elpp","battt","tab","c","c"};
        Map<String,String> results = new HashMap<String,String>();
        results.put("cba","abc");
        results.put("cb", "aabc");

        Map<String,String> retResults = getPalindromes(input);

        //there should be 2 pairs
        if(retResults.size() != 6){
            myassert(false);
        }

        //check if returned pairs are correct
        for(Map.Entry e: results.entrySet()){
            if(!e.getValue().toString().equalsIgnoreCase(retResults.get(e.getKey()))){
                myassert(false);
            }
        }

    }

    public void testbasic(){
        String[] input = {"abc","cba","xyzaf","apple","elppa","money","monkey","abc"};
        Map<String,String> results = new HashMap<String,String>();
        results.put("cba","abc");
        results.put("elppa", "apple");

        Map<String,String> retResults = getPalindromes(input);

        for(Map.Entry e: results.entrySet()){
            if(!e.getValue().toString().equalsIgnoreCase(retResults.get(e.getKey()))){
                myassert(false);
            }
        }

    }

    public void testbed(){
        //testbasic();
        testbasic2();
    }

    public static void main(String args[]){
        PalindromeStrings ps = new PalindromeStrings();
        ps.testbed();
    }
}
