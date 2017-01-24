package airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnuka on 7/6/16.
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        int wordsCount = words.length;
        ArrayList<String> result = new ArrayList<String>();
        int curLen = 0;
        int lastI = 0;
        for (int i = 0; i <= wordsCount; i++) {
            if (i == wordsCount || curLen + words[i].length() + i - lastI > L) {
                StringBuffer buf = new StringBuffer();
                int spaceCount = L - curLen;
                int spaceSlots = i - lastI - 1;
                if (spaceSlots == 0 || i == wordsCount) {
                    for(int j = lastI; j < i; j++){
                        buf.append(words[j]);
                        if(j != i - 1)
                            appendSpace(buf, 1);
                    }
                    appendSpace(buf, L - buf.length());
                } else {
                    int spaceEach = spaceCount / spaceSlots;
                    int spaceExtra = spaceCount % spaceSlots;
                    for (int j = lastI; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1)
                            appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
                    }
                }
                result.add(buf.toString());
                lastI = i;
                curLen = 0;
            }
            if (i < wordsCount)
                curLen += words[i].length();
        }
        return result;
    }

    private void appendSpace(StringBuffer sb, int count) {
        for (int i = 0; i < count; i++)
            sb.append(' ');
    }

    public void myassert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fails");
        }
    }

    public void testcase2(){
        String input = "abcdef I ant test I bad I";
        // System.out.println(input);
        // System.out.println(input.replaceAll("\\s+", " "));
        String[] words = input.replace("\\s+"," ").split(" ");
        List<String> results = fullJustify(words,6);
        for(String s: results){
            System.out.println(s);
        }
    }

    public void testcase1(){
        String input = "This is a great game where everyone though golden state warriors can win easily but things turned" +
                       "    out sour for them from game 5, Caveliers showed outstanding performance later and won the game" +
                       " game   from GS Warrios at the end";
       // System.out.println(input);
       // System.out.println(input.replaceAll("\\s+", " "));
        String[] words = input.replace("\\s+"," ").split(" ");
        List<String> results = fullJustify(words,20);
        for(String s: results){
            System.out.println(s);
        }
    }

    public void testbed(){
        testcase1();
       // testcase2();
    }

    public static void main(String args[]){
        TextJustification tj = new TextJustification();
        tj.testbed();
    }
}
