package practice.coding.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Question: Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the
original list of strings.
 */
public class EncodeDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }

    void testcase1(List<String> input){
        String encodeString = encode(input);
        System.out.println("encoded String="+encodeString);
        List<String> results = decode(encodeString);
        System.out.println("Decoded String are::");
        for(String s: results){
            System.out.println(s);
        }
    }

    static void testbed(){
        EncodeDecodeStrings e = new EncodeDecodeStrings();
        e.testcase1(Arrays.asList(new String[]{"a/t", "apple"}));
    }
    public static void main(String args[]){
        testbed();
    }
}
