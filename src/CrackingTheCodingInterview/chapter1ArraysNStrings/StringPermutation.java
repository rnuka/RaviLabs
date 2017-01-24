package CrackingTheCodingInterview.chapter1ArraysNStrings;

/**
 * Created by rnuka on 10/5/15.
 */

/**
 * Question 1.3: Given two strings, write a method to decide if one is a permutation of the other.
 */
public class StringPermutation {


    //My Code:
    Boolean IsString1PermutationOfString2(String s1, String s2){
        Integer[] characterCount = new Integer[256];

        //if input lengths are different then return false
        if(s1.length() != s2.length())
            return false;

        //process first string
        for(char ch : s1.toCharArray()){
            if(characterCount[ch]==null)
                characterCount[ch]=1;
            else
                characterCount[ch] = characterCount[ch]+1;
        }

        //process second string by decrementing
        for(char ch : s2.toCharArray()){
            if(characterCount[ch]==null)
                return false;
            else
                characterCount[ch] = characterCount[ch]-1;
        }

        for(Integer counter : characterCount){
            if(counter != null && counter != 0)
                return false;
        }
        return true;
    }


    //Book Code
    Boolean permutation(String s1, String s2){
        Integer[] characterCount = new Integer[256];

        //if input lengths are different then return false
        if(s1.length() != s2.length()) {
            return false;
        }

        //process first string
        for(char ch : s1.toCharArray()) {
            characterCount[ch]++;
        }

        //process second string by decrementing
        for(char ch : s2.toCharArray()) {
            if (--characterCount[ch] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        StringPermutation sp = new StringPermutation();
        String input1 = "raa VI";
        String input2 = "VI aar";
        System.out.println("value=" + sp.IsString1PermutationOfString2(input1, input2));
    }
}
