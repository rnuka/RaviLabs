package practice.coding.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rnuka on 11/11/16.
 */

/*
* Question:

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".


* */
public class Element {

    //see if word break is possible to form dictionary words
    public boolean isElemental(String input, Set<String> dictionary){

        int inputLength = input.length();
        boolean[] results = new boolean[inputLength+1];
        results[0] = true;



        for(int i=0 ; i<inputLength ; i++){
            for(int j=i+1 ; j<=inputLength && results[i] ; j++){
                if(dictionary.contains(input.substring(i,j))){
                    results[j] = true;
                }
            }
        }

        return results[inputLength];

    }



    //return word break list of words
    public List<String> getElements(String input, Set<String> dictionary){

        int inputLength = input.length();
        boolean[] results = new boolean[inputLength+1];
        results[0] = true;



        for(int i=0 ; i<inputLength ; i++){
            for(int j=i+1 ; j<=inputLength && results[i] ; j++){
                if(dictionary.contains(input.substring(i,j))){

                    //mark previous ones to false so that largest word is taken care
                    /*for(int k=i+1; k<j ; k++){
                        results[k] = false;
                    }*/

                    results[j] = true;

                }

            }
        }


        //Loop through results and forms words by appending all false until true position comes.
        List<String> resultList = new ArrayList();
        if(results[inputLength]){
            /*for(int i=1; i<=inputLength; i++){
                temp.append(input.charAt(i-1));
                if(results[i]){
                    resultList.add(temp.toString());
                    temp=new StringBuffer("");
                }
            }*/

            for(int i=inputLength-1; i>0; i--){
                StringBuffer temp = new StringBuffer("");
                while(dictionary.contains(temp)){
                    temp.insert(0,input.charAt(i));
                }
            }
        }

        return resultList;

    }

    public void myassert(boolean  x) {
        if (!x) {
            throw new IllegalArgumentException("Assert fail") ;
        }
    }

    public void testcase1(){
        String input = "helo";
        Set<String> dictionary = new HashSet<>();
        dictionary.add("he");
        dictionary.add("el");
        dictionary.add("lo");

        //dictionary.add("l");

        myassert(isElemental(input,dictionary));


    }

    public void testcase2(){
        String input = "helo";
        Set<String> dictionary = new HashSet<>();
        dictionary.add("he");
        dictionary.add("el");
        dictionary.add("lo");
        dictionary.add("h");


        if(isElemental(input,dictionary)){
            List<String> results = getElements(input,dictionary);
            for(String s : results){
                System.out.println("word :: "+s);
            }
        }else{
            System.out.println("Invalid String");
        }


    }


    public void testcase3(){
        String input = "aceman";
        Set<String> dictionary = new HashSet<>();
        dictionary.add("a");
        dictionary.add("ace");
        dictionary.add("an");
        dictionary.add("man");



        if(isElemental(input,dictionary)){
            List<String> results = getElements(input,dictionary);
            for(String s : results){
                System.out.println("word :: "+s);
            }
        }else{
            System.out.println("Invalid String");
        }


    }

    public void testcase4(){
        String input = "aaaisaname";
        Set<String> dictionary = new HashSet<>();
        dictionary.add("a");
        dictionary.add("aaa");
        dictionary.add("ais");
        dictionary.add("name");



        if(isElemental(input,dictionary)){
            System.out.println("inside if clause");
            List<String> results = getElements(input,dictionary);
            for(String s : results){
                System.out.println("word :: "+s);
            }
        }else{
            System.out.println("Invalid String");
        }


    }



    public void testbed(){
        testcase1();
        testcase4();
    }
    public static void main(String args[]){
        Element e = new Element();
        e.testbed();
    }
}
