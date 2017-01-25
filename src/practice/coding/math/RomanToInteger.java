package practice.coding.math;

import java.util.HashMap;
import java.util.Map;

/*
Question: Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Link: https://leetcode.com/problems/roman-to-integer/


 */
public class RomanToInteger {


    public Integer convert(String s){

        if(s == null){
            return null;
        }

        char[] romanNumerals = s.toCharArray();

        //pre-map
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        //traverse from end and check
        int prevVal = 0;
        int value = 0;
        for(int i=romanNumerals.length-1; i>=0; i--){
            if(!map.containsKey(romanNumerals[i])){  //invalid characters case
                return null;
            }else {
                int currVal = map.get(romanNumerals[i]);
                if(currVal > prevVal){
                    value += currVal;
                }else{
                    value -= currVal;
                }
                prevVal = currVal;
            }
        }
        return value;
    }

    void testcase1(String s){
        System.out.println("value of "+s+" is::"+convert(s));
    }

    void testbed(){
        testcase1("MCMXCIX");
    }

    public static void main(String args[]){
        RomanToInteger r = new RomanToInteger();
        r.testbed();
    }
}
