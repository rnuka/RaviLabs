package practice.coding.strings;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Question: Given a string, find the first non-repeating (i.e. unique) character in it and return it's index.
If it doesn't exist, return -1.

Note: You may assume the string contain only lowercase letters.

Example-1:
----------
input: "dad"
output: 1

Example-2:
----------
input: "mother"
output: 0

Example-3:
----------
input: "aaa"
output: -1


FOLLOW-UP: What if additional data structure is not allowed.
---------
 */

/*
Bruteforce - two for loops i, j on s and check if repeats and return i value -> Time = O(n^2) and space=O(1)
Optimal solution - use LinkedHashMap and for loop to populate LHM and return accordingly -> Time = O(n) and space=O(n)
 */
public class FirstUniqueCharacterInString {

    //Approach-1
    public int firstNonRepeat(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = counts.get(s.charAt(i));
            counts.put(s.charAt(i), count == null ? i : -1);
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.println("entry char="+entry.getKey()+" and value="+entry.getValue());
            if (entry.getValue() >= 0) {
                return entry.getValue();
            }
        }


        return -1;

    }

    //Approach-2
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return -1;
        }
        int[] charCounts = new int[256];
        //populate
        for(int i=0; i<s.length(); i++){
            charCounts[s.charAt(i)]++;
        }

        //lookup
        for(int i=0; i<s.length(); i++){
            if(charCounts[s.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }

    public static char getFirstNonRepeatedChar(String str) {
        Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    public void testcase6() {
        System.out.println(" ******* TESTCASE-6 ***********");
        String input = "leetcode";
        System.out.println("first non repeat of input::" + input + " is::" + firstNonRepeat(input));
    }

    public void testcase5() {
        System.out.println(" ******* TESTCASE-5 ***********");
        String input = "leetcode";
        System.out.println("first non repeat of input::" + input + " is::" + getFirstNonRepeatedChar(input));
    }


    public void testcase4() {
        System.out.println(" ******* TESTCASE-4 ***********");
        String input = "cccaabadb";
        System.out.println("first non repeat of input::" + input + " is::" + firstNonRepeat(input));
    }

    public void testcase3() {
        System.out.println(" ******* TESTCASE-3 ***********");
        String input = "dddccdbba";
        System.out.println("first non repeat of input::" + input + " is::" + firstNonRepeat(input));
    }

    public void testcase2() {
        System.out.println(" ******* TESTCASE-2 ***********");
        String input = "mother";
        System.out.println("first non repeat of input::" + input + " is::" + firstNonRepeat(input));
    }

    public void testcase1() {
        System.out.println(" ******* TESTCASE-1 ***********");
        String input = "dad";
        System.out.println("first non repeat of input::" + input + " is::" + firstNonRepeat(input));
    }

    public void testbed() {
         testcase1();
         testcase2();
         testcase3();
        testcase4();
        testcase5();
        testcase6();
    }

    public static void main(String args[]) {
        FirstUniqueCharacterInString f = new FirstUniqueCharacterInString();
        f.testbed();
    }
}
