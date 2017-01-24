package practice.coding.graphs;

import java.util.*;

/**
 * Created by rnuka on 9/25/15.
 */
public class BfsPaths {

    List<Set<Vertex>> bfsFinalPaths = new ArrayList<Set<Vertex>>();
    Map<Vertex, Set<Vertex>> bfsPathMap = new TreeMap<Vertex,Set<Vertex>>();
    Set<Vertex> currentQueuePath = new LinkedHashSet<Vertex>();
    Queue<Vertex> bfsQueue = new PriorityQueue<Vertex>();

    public void bfsPath(GraphAdjacencyList g, Vertex startNode, Vertex targetNode){

        currentQueuePath.add(startNode);
        bfsPathMap.put(startNode, currentQueuePath);

        //if source=target
        if(startNode.data == targetNode.data) {
            return;
        }

        //all other cases
        bfsQueue.add(startNode);
        while(!bfsQueue.isEmpty()){
            Vertex currentNode = bfsQueue.poll();

            if(g.graph.get(currentNode) != null) {
                for (Vertex v : g.graph.get(currentNode)) {
                    currentQueuePath = new LinkedHashSet<Vertex>();
                    bfsQueue.add(v);

                    //save the path
                    currentQueuePath.addAll(bfsPathMap.get(currentNode));
                    currentQueuePath.add(v);

                    //print the path
                    if(v == targetNode){
                        bfsFinalPaths.add(currentQueuePath);
                    }
                    bfsPathMap.put(v, currentQueuePath);
                }
            }
        }

    }

    public static void main(String args[]){

        Vertex v1= new Vertex(1);
        Vertex v2= new Vertex(2);
        Vertex v3= new Vertex(3);
        Vertex v4= new Vertex(4);
        Vertex v5= new Vertex(5);
        Vertex v6= new Vertex(6);


        GraphAdjacencyList g = new GraphAdjacencyList();

        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v2,v4);
        g.addEdge(v3,v5);
        g.addEdge(v5,v6);
        g.addEdge(v4, v6);

        BfsPaths bfs = new BfsPaths();
        bfs.bfsPath(g, v1, v6);

        if(bfs.bfsFinalPaths.isEmpty()){
           System.out.println("No path exists");
        }else {
            for (Set<Vertex> vertexSet : bfs.bfsFinalPaths) {
                System.out.println(" ");
                for (Vertex v : vertexSet) {
                    System.out.print(" " + v.data);
                }
            }
        }
    }


}
