package CrackingTheCodingInterview.chapter1ArraysNStrings;

/**
 * Created by rnuka on 10/6/15.
 */
/*
Question 1.4: Write a method to replace all spaces in a string with'%20'. You may assume that
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the "true" length of the string. (Note: if implementing
in Java, please use a character array so that you can perform this operation
in place.)
EXAMPLE
Input: "Mr John Smith
Output: "Mr%20Dohn%20Smith"
 */
public class StringReplaceSpacesWithx20 {
    String replace(String input){
        StringBuilder sb = new StringBuilder();
        for(char ch : input.toCharArray()){
            if(ch == ' ')
                sb.append("%20");
            else
                sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String args[]){
        StringReplaceSpacesWithx20 sr = new StringReplaceSpacesWithx20();
        System.out.println(" string replace = "+sr.replace("ravi works at twitter"));
    }
}
