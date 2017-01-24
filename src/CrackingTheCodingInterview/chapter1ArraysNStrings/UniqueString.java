package CrackingTheCodingInterview.chapter1ArraysNStrings;

/**
 * Created by rnuka on 10/5/15.
 */
/*
Question 1.1a: Implement an algorithm to determine if a string has all unique characters.
Question 1.1b: What if you cannot use additional data structures?
* */
public class UniqueString {


    //My Code: ================================================

    /*
    Time complexity: O(n)
    */

    Boolean isUniqueString(String input){
        //array to store alphabet hits
        Boolean[] validateArray = new Boolean[256];

        //if length is greather than 26 characters return false
        if(input.length() > 256)
            return false;

        //check entire string to see if any duplicates present
        for(char ch: input.toCharArray()){
            if(validateArray[ch]== null)
                validateArray[ch]=true;
            else
                return false;
        }
        return true;
    }

    //Book Solution: ================================================

    Boolean isUniqueString2(String input){
        //array to store alphabet hits
        Boolean[] validateArray = new Boolean[256];

        //if length is greather than 26 characters return false
        if(input.length() > 256)
            return false;

        //check entire string to see if any duplicates present
        for(char ch: input.toCharArray()){
            if(validateArray[ch])
                return false;
            validateArray[ch]=true;
        }
        return true;
    }






    /*********** 1b *****************/

   /*
    Time complexity: O(n^2)
   */
    Boolean isUniqueString3(String input){
        for(int i=0; i<input.length(); i++){
            for(int j=i+1; j<input.length(); j++){
                if(input.charAt(i) == input.charAt(j))
                    return false;
            }
        }
        return true;
    }


    /******* using bitwise operator ***********/
    public boolean isUniqueChars(String str) {

        long checker = 0;
        long initVal = 1;
        for (int i=0; i < str.length(); i++) {
            long val = str.charAt(i) - 'A';

            if ((checker & ( 1L << val)) > 0) {
                return false;
            }
            checker |= ( 1L << val);
            System.out.println(Long.toBinaryString(checker));
        }
        return true;
    }



    public static void main(String args[]){
        UniqueString us = new UniqueString();
        String input = "rais";
        System.out.println("Is "+input+" unique? = " + us.isUniqueString(input));
       // System.out.println("Is "+input+" unique2? = " + us.isUniqueString2(input));
    }
}
