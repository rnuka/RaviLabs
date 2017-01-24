package CrackingTheCodingInterview.chapter1ArraysNStrings;

/**
 * Created by rnuka on 10/5/15.
 */
/*
Question 1.2: Implement a function void reverse(char* str) in C or C++ which reverses a nullterminated
string.
 */
public class ReverseString {

    /*
    Time complexity : O(n)
    */

    //My Solution
    String reverse(String input){
        if (input==null)
            return null;
        else{
            StringBuilder sb = new StringBuilder();
            for(char ch : input.toCharArray())
                sb.insert(0,ch);
            return sb.toString();
        }
    }


    //My Solution2: use stringbuilder builtin method
    String reverse2(String input){
        return new StringBuilder(input).reverse().toString();
    }


    //Book Solution using c-language
    /*
    void reverse(char *str) {
        char* end = str;
        char tmp;
        if (str) {
             while (*end) { // find end of the string
                 ++end;
            }
             --end;
             // set one char back, since last char is null
             // swap characters from start of string with the end of the
             // * string, until the pointers meet in middle.
             while (str < end) {
                 tmp = *str;
                 *str++ = *end;
                 *end-- = tmp;
                 }
             }
         }
    */

    public static void main(String args[]){
        String input="ravi is a good boy"+null;
        ReverseString rs = new ReverseString();
        System.out.println("reverse of "+input+" is::"+rs.reverse(input));
        System.out.println("reverse of "+input+" is::"+rs.reverse2(input));
    }
}
