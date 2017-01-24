package practice.coding.recursion;

import java.util.HashSet;
import java.util.Set;

/*
Write a program that answers YES/NO search queries containing * placeholders.

Example: if the data you have is (hazem, ahmed, moustafa, fizo), then you should answer as follows for:
 ahmed: YES
 m**stafa: YES
 fizoo: NO
 fizd: NO
 *****: YES
 ****: YES 
**: NO
 Your program should be able to answer each search query in O(1).

link: https://www.careercup.com/question?id=5669407776833536

 */
public class StringSearch {

    Set<String> words = new HashSet<>();

    /**
     *
     * @param source
     */
    void populate(String source){
        for(String original: source.split(", ")){
            {
             populate(original, "", 0);
            }
        }

    }

    /**
     *
     * @param original
     * @param edited
     * @param charCount
     */
    void populate(String original, String edited, int charCount){
        if(charCount>=original.length()){
            words.add(edited);
        }
        populate(original, edited+original.charAt(charCount), charCount+1);
        populate(original, edited+"*", charCount+1);
    }

    boolean search(String word){
        return words.contains(word);
    }


    public static void main(String args[]){

    }


}
