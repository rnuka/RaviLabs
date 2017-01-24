package CrackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.*;

/**
 * Created by rnuka on 10/17/15.
 */
public class Graph {
    Map<Vertex, List<Vertex>> adjacencyList;
    public Graph(){
        adjacencyList = new HashMap<Vertex,List<Vertex>>();
    }

    public void addEdge(Vertex from, Vertex to){
        List<Vertex> edgeList = null;
        if(adjacencyList.get(from) != null){
            edgeList = adjacencyList.get(from);
            edgeList.add(to);
        }else{
            edgeList = new ArrayList<Vertex>();
            edgeList.add(to);
        }
        adjacencyList.put(from, edgeList);
    }

    //to print level by level of graph
    public void printLevelOrder(Vertex root){
        Queue<Vertex> myQueue = new LinkedList<Vertex>();
        myQueue.add(root);
        myQueue.add(null);
        //while queue is not empty, traverse in bfs approach
        while(!myQueue.isEmpty()){
            Vertex curr = myQueue.remove();

            //if null node comes which is level change indicator
            // then insert null at back if queue has still some elements
            if(curr == null ){
                if( !myQueue.isEmpty()) {
                    myQueue.add(curr);
                }
                System.out.println("");
            }else{
                //print level
                System.out.print(curr.data + " ");
                //otherwise insert all childs to the queue
                if(adjacencyList.get(curr) != null) {
                    for (Vertex v : adjacencyList.get(curr)) {
                        myQueue.add(v);
                    }
                }
            }


        }

    }

    //test
    public static void main(String[] args){
        Graph g = new Graph();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);

        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v2,v4);
        g.addEdge(v3,v5);
        g.addEdge(v4,v6);
        g.addEdge(v5,v7);

        g.printLevelOrder(v1);

    }
}
