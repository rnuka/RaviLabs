package CrackingTheCodingInterview.chapter1ArraysNStrings;

/**
 * Created by rnuka on 10/8/15.
 */
/*
Question 1.8: Assume you have a method isSubstring which checks if one word is a
substring of another. Given two strings, si and s2, write code to check if s2 is
a rotation of si using only one call to isSubstring (e.g.,"waterbottle"is a rotation
of "erbottlewat").
 */
/*
Assumptions:
    1. String functions are allowed
*/
public class StringRotation {

    Boolean areStringsRotated(String s1, String s2){
        if( s1 != null && s2 != null
                && s1.length() == s2.length()
                && (s2+s2).contains(s1)
                )
            return true;
        return false;
    }

    public static void main(String[] args){
        String s1 = "waterbottle";
        String s2 = "erbottlewaterbottle";
        //String s1 = null;
        //String s2 = null;
        StringRotation sr = new StringRotation();
        System.out.println("s1="+s1+" and s2="+s2+". Are they rotations? ::"+sr.areStringsRotated(s1,s2));
    }

}
