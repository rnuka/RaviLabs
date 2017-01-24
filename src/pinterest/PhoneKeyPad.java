package pinterest;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
*

 *
 * Phone keypad
 * 2 = > a b c
 * 3 = > d e f
 *
 * Input: A string of integers say "23"
 * Output:  all the possible words you could come up with a phone keypad
 *  [ad ae af bd be bf cd ce cf]

 1. f(n) = [all characters of n] when n=1
 2. [d e f]
 3. [ad, ae, af, bd, be, bf, cd, ce, cf]...


* */
public class PhoneKeyPad {
    public List<String> keypadWords(String input,   Map<Integer,List<String>> dictionary){

        //Null or Empty case
        if(input == null || input.length() ==0 || !input.matches("[0-9]+")){
            return null;
        }

        List<String> output = new ArrayList<String>();

        //if input length is 1
        if(input.length() == 1){
            output.addAll(dictionary.get(input));
        }
        else {
            //Other cases: Extract the first character and recurse
            String subString = input.substring(1);
            List<String> results = keypadWords(subString, dictionary);

            for (String curr : dictionary.get(input.substring(0, 1))) {
                for (String currResult : results) {
                    output.add(curr + currResult);
                }
            }
        }

        return output;

    }


    public static void main(String[] args) {

    }
}
