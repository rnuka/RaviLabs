package com.orange.spellchecker;

/**
 * Created by rnuka on 7/8/16.
 */
public class MinimumEditTest {

    public static void main(String args[]){
        String s="baitt";
        String t="cat";
        MinimumEdits me = new MinimumEdits(s,t);
        System.out.println("minimum distance of cat and baitt is "+me.minimumEdit(s,t));
    }
}
