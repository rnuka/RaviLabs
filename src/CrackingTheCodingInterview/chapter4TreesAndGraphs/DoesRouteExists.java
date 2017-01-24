package CrackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rnuka on 10/16/15.
 */
/*
Question: 4.2 Given a directed graph, design an algorithm to find out whether there is a route
between two nodes.
 */

/*
1. Input: Graph G, Source S, Target T
2. Output: Path Exists: T/F
*/
public class DoesRouteExists {

    public enum State{
        Unvisited, Visited;
    }

    //Node it is graph but not tree so there can n childs per parent
    //take source as root and do a bfs or dfs till you find target or complete graph traversal is completed
    boolean doesRouteExists(Graph g, Vertex u, Vertex v){

        Queue<Vertex> buffer = new LinkedList<Vertex>();

        //initialize all nodes to unvisited

        u.state = State.Unvisited.toString();
        buffer.add(u);

        int counter = 0;
        while(!buffer.isEmpty() && ++counter < 10){

            Vertex curr = buffer.remove();

            if(curr != null){

                //if target found
                if(curr.data == v.data){
                    return true;
                }

                System.out.println("----");
                //otherwise continue search
                if(g.adjacencyList.get(curr) != null) {
                    for (Vertex vertex : g.adjacencyList.get(curr)) {
                        if (vertex.state.equalsIgnoreCase(State.Unvisited.toString())) {
                            System.out.println("adding node ::"+vertex.data);
                            buffer.add(vertex);
                        }
                    }
                }

                //update the current node as visited
                curr.state = State.Visited.toString();

            }


        }

        return false;
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
        Vertex v8 = new Vertex(8);

        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v2,v4);
        g.addEdge(v2,v3);
        g.addEdge(v2,v1);
        g.addEdge(v3, v5);
        g.addEdge(v4, v6);
        g.addEdge(v5, v7);

        DoesRouteExists dre = new DoesRouteExists();
        System.out.println(" does path from"+v1.data+" to"+v8.data+" exists? Ans::"+dre.doesRouteExists(g,v1,v8));

    }
}
