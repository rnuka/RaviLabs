package practice.coding.others;

import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Created by rnuka on 4/12/16.
 */
/*
* Question: Given a stream of pair of strings:
    find if they are related to each other.
    if not, create a relation between them.

class Relation {
    boolean isRelated(String value1, String value2)
}

e.g.
A, B => false (A and B are not related)
B, A => true (A and B are related as we formed the relation between A and B in previous step)
A, B => true (same as above)
C, D => false (new relation)
B, C => false (new relation)
A, D => true (A is related to B, B is related to C, C is related to D)
A, C => true (A is related to B, B is related to C)
* */
public class Relation {

    Map<String, List<String>> graph = new ConcurrentHashMap<String, List<String>>();

    public boolean checkIfExists(String value1, String value2, String prevVal){
        //System.out.println("checking for value1="+value1+ " and value2="+value2);
        //if value1 equals value2 return true
        if(value1.equalsIgnoreCase(value2)){
            return true;
        }

        //else navigate the entire graph using a DFS traversal and see if there exists a relationship
        List<String> currAdjList = graph.get(value1);
        for(String str: currAdjList){
            //System.out.println("str="+str);
           if(!str.equalsIgnoreCase(prevVal)) {
               Boolean temp = checkIfExists(str, value2, value1);
               if(temp){return true;}
           }

        }
        return false;

    }

    public void populateGraphEdge(String value1, String value2){
        //System.out.println("adding relationship for value1="+value1+" and value2="+value2);
        //part-1

        if(graph.get(value1) != null) {
            graph.get(value1).add(value2);
        }else {
            List<String> adjList = new ArrayList<String>();
            adjList.add(value2);
            graph.put(value1, adjList);
        }
        return;
    }

    boolean isRelated(String value1, String value2){

        //step-1: check if str1 has str2 in its adjacency list
        List<String> currList = graph.get(value1);
        if(graph.get(value1) != null) {
            if(checkIfExists(value1, value2, value1+value2)){
                return true;
            }
        }

        //step-2: value1 and value2 are completely new
        //then add value1 to key and value2 to adjacency relation ship and return false
        populateGraphEdge(value1, value2);
        populateGraphEdge(value2, value1);

        return false;
    }

    public static void main(String args[]){
        Relation relation = new Relation();
        System.out.println("relation for A,B is = "+relation.isRelated("A", "B"));
        System.out.println("relation for B,A is = " + relation.isRelated("B", "A"));
        System.out.println("relation for A,B is =" + relation.isRelated("A", "B"));
        System.out.println("relation for C,D is = " + relation.isRelated("C", "D"));
        System.out.println("relation for B,C is =" + relation.isRelated("B", "C"));
        System.out.println("relation for A,D is =" + relation.isRelated("A", "D"));
        System.out.println("relation for A,C is =" + relation.isRelated("A", "C"));
        System.out.println("relation for B,D is =" + relation.isRelated("B", "D"));
        System.out.println("relation for E,F is =" + relation.isRelated("E", "F"));
        System.out.println("relation for A,F is =" + relation.isRelated("A", "F"));
        System.out.println("relation for B,E is =" + relation.isRelated("B", "E"));
    }

}
