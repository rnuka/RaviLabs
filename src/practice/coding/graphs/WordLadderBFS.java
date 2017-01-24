package practice.coding.graphs;

/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end,
 such that only one letter can be changed at a time and each intermediate word must exist in the dictionary.


Example: 1

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.


Example


* */

/*
Approach: Form a graph with start and target node and keep adding one edit distance edges to start node
and keep increasing height. whenever you hit target, you hit the height.
 */

/*
Solution: http://www.programcreek.com/2012/12/leetcode-word-ladder/
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderBFS {
    public int countTransformations(Set<String> dictionary, String source, String target){

        //step-1: make sure target is part of dictionary
        dictionary.add(target);

        //step-2: do a bfs and get transformation distance
        int count = 0;
        Queue<String> bfs = new LinkedList<>();
        bfs.add(source);
        bfs.add(null);
        while(!bfs.isEmpty()){
            String curr = bfs.poll();
            if(curr==null){
                count++;
                if(!bfs.isEmpty()) {
                    bfs.add(curr);
                }
            }else {
                if (curr.equalsIgnoreCase(target)) {
                    return count+1; //purpose of +1 is to add the last conversion count.
                } else {
                    //add all one edit elements to queue
                    addOneEdits(bfs, dictionary, curr);
                }
            }

        }
        return Integer.MAX_VALUE;
    }

    void addOneEdits(Queue<String> queue, Set<String> dictionary, String currentWord){
        char[] word = currentWord.toCharArray();
        for(int i=0; i<word.length; i++){
            for(char j='a'; j<'z'; j++){
                if(j != word[i]){
                    char temp = word[i]; //preserve current char
                    word[i]=j; //replace with new char
                    String newWord = new String(word);
                    if(dictionary.contains(newWord)){
                        queue.add(newWord);
                        dictionary.remove(newWord);
                    }
                    word[i]=temp; //revert to original char after adding word to dictionary
                }
            }
        }
    }

    public void testcase1(){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("hot");
        dictionary.add("lot");
        dictionary.add("dot");
        dictionary.add("dog");
        dictionary.add("log");

        String source = "hit";
        String target = "cog";
        System.out.println("transformation distance for source+"+source+" to target::"+target+" is :: "+
                countTransformations(dictionary,source, target));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        WordLadderBFS w = new WordLadderBFS();
        w.testbed();
    }
}
