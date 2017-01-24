package practice.coding.strings;
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example1: "Red rum, sir, is murder" is a palindrome
Example2: "Programcreek is awesome" is not palindrome

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.For the purpose of this
problem, we define empty string as valid palindrome.
 */
public class IsValidPalindrome {

    public boolean isValidPalindrome(String input){

        int i=0, j=input.length()-1;

        while (i<j){
            //move i from begin to end to find valid character
            while( !isValidChar(input.charAt(i))){
                i++;
            }

            //move j from end to begin to find valid character
            while( !isValidChar(input.charAt(j))){
                j--;
            }

            if(input.charAt(i)!= input.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;

    }

    private boolean isValidChar(char ch){
        if((ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z') ||
                (ch >= '0' && ch <= '9')){
            return true;
        }
        return false;
    }


}
