package airbnb;

import java.util.*;

/**
 * Created by rnuka on 6/4/16.
 */
/*
* There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
For example,
Given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".
Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
* */

public class AlienDictionary {


  public class Graph{
     Map<Character, List<Character>> graph;
     public void graph(){
       graph = new HashMap<Character,List<Character>>();
     }

    public int size(){
      return graph.size();
    }

    //print level order using bfs
    public void printGraph(Character source){
      Queue<Character> bfsQueue = new LinkedList<Character>();
      Map<Character, Character> visitedNodes = new HashMap<>();
      bfsQueue.add(source);
      Character lineLimit = '~';
      while(!bfsQueue.isEmpty()){
        Character currentNode = bfsQueue.remove();
        if(currentNode != '~') {
          System.out.print(currentNode+" ");
        }else{
          System.out.println("----");
        }


        for(Character currChar: graph.get(currentNode)){
          if(! visitedNodes.containsKey(currChar)) {
            bfsQueue.add(currChar);
            visitedNodes.put(currChar, currChar);
          }
        }
        if(graph.containsKey(currentNode)) {
          bfsQueue.add(lineLimit);
        }

      }
    }
  }

  Graph g = new Graph();


  //create a graph of alphabets

  //read each word and form alphabet relationship
  private void createGraph(List<String> input){
    int totalWords = input.size();
    for(int i=0; i< totalWords-1; i++){
      relateChars(input.get(i), input.get(i+1));
    }
  }

  private void relateChars(String first, String second){
    int firstSize = first.length();
    int secondSize = second.length();

    //loop through each character and build relationship
    for(int i=0; i<firstSize & i<secondSize; i++){
      char firstWordChar = first.charAt(i);
      char secondWordChar = second.charAt(i);

      if(firstWordChar != secondWordChar){
        if(g.graph.containsKey(firstWordChar)){
          g.graph.get(firstWordChar).add(secondWordChar);
        }else{
          List<Character> chars = new LinkedList<>();
          chars.add(secondWordChar);
          g.graph.put(firstWordChar, chars);
        }
        break;
      }
    }

  }


  public List<Character> alienDictionary(List<String> input){
    List<Character> results = new ArrayList<>();
    createGraph(input);
    g.printGraph(input.get(0).charAt(0));
    return results;
  }



}
