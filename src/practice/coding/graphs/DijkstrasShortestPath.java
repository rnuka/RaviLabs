package practice.coding.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rnuka on 10/3/15.
 */
/*
input: non negative length and non cyclic graph , source vertex and destination vertex
output: shortest path b/w source vertex and destination vertex and return -1 if path doesn't exist.
*/
public class DijkstrasShortestPath {

    List<Vertex> pathList = new ArrayList<Vertex>();

    //initialize
    public void initializeGraph(GraphAdjacencyList adjancencyList){
        for(Map.Entry<Vertex,List<Vertex>> edgeList : adjancencyList.graph.entrySet()){
           for(Vertex v: edgeList.getValue()){
               if(!(v.weight > 0)){
                   v.weight = -1; //assume -1 means inifinity
               }
           }
        }
    }

    //Adjacency List shortest path method
    List<Vertex> shortestPath(GraphAdjacencyList adjacencyList, GNode source, GNode destination){

        //initialize
        initializeGraph((adjacencyList));

        //travel from source until target is reached or graph is completely visited
        List<GNode> visitedNodes = new ArrayList<GNode>();
        visitedNodes.add(source);


        return pathList;
    }

    public static void main(String args[]){
        GraphAdjList g = new GraphAdjList();
        GNode v1= new GNode(1);
        GNode v2= new GNode(2);
        GNode v3= new GNode(3);
        GNode v4= new GNode(4);
        GNode v5= new GNode(5);
        GNode v6= new GNode(6);
        g.addEdge(v1,v2,1);
        g.addEdge(v2,v1,1);
        g.addEdge(v1,v3,2);
        g.addEdge(v3,v1,2);
        g.addEdge(v2,v4,6);
        g.addEdge(v4,v2,6);
        g.addEdge(v3,v5,1);
        g.addEdge(v5,v3,1);
        g.addEdge(v4,v6,2);
        g.addEdge(v6,v4,2);
        g.addEdge(v5,v6,1);
        g.addEdge(v6,v5,1);

        g.printGraph();
    }
}
