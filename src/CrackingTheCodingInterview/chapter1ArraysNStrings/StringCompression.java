package CrackingTheCodingInterview.chapter1ArraysNStrings;

/**
 * Created by rnuka on 10/6/15.
 */



/*
Question 1.5: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.
 */

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class StringCompression {

    String compressedString(String s){
        if(s == null)
            return null;

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i=0; i<s.length(); i++){
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                count++;
            }else{
                sb.append(s.charAt(i)).append(count);
                count=1;
            }
        }

        if(sb.length() >= s.length())
            return s;

        return sb.toString();
    }

   /* public static void main(String args[]){
        String input = "aaaaabcc";
        StringCompression sc = new StringCompression();
        System.out.print("compressed String of"+input+" is::"+sc.compressedString(input));
    }*/

    @Test
    public void testEmptyCollection() {
        assertEquals("a2b1c5a3d1", compressedString("aabcccccaaad"));
    }

    @Test
    public void testBasic() {
        assertEquals("a3b3c2d1", compressedString("aaabbbccd"));
    }
}
