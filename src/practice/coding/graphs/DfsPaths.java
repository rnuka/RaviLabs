package practice.coding.graphs;

import java.util.*;

/**
 * Created by rnuka on 9/23/15.
 */
public class DfsPaths {

    Stack<Vertex> dfsPath = new Stack<Vertex>();
    List<Set<Vertex>> dfsPathSet = new ArrayList<Set<Vertex>>();
    /*
    * 1. add the source to stack
    * 2. get top element and look for its children
    * 3. if children exits, push them to stack else pop the top element and add it to dfsPath array.
    * 4. if target node is reached then return true
    * 5. if stack is empty then return false
    * */
    public void dfs(GraphAdjacencyList g, Vertex sourceVertex, Vertex destinationVertex){

        //add source to path
        dfsPath.push(sourceVertex);


        //if source and destination are same
        if(sourceVertex.equals(destinationVertex)){

            //add the path to path set
            Set<Vertex> pathList = new LinkedHashSet<Vertex>();
            for (Vertex v : dfsPath) {
                pathList.add(v);
            }
            dfsPathSet.add(pathList);

        }else {

            //mark as visited
            sourceVertex.visited = true;

            //dfs if childs exist
            for (Vertex currVertex : g.graph.get(sourceVertex))
                if (!currVertex.visited)
                    dfs(g, currVertex, destinationVertex);
        }

        //pop element after all child recursions
        dfsPath.pop();




    }

    public static void main(String args[]){
        GraphAdjacencyList g = new GraphAdjacencyList();
        Vertex v1= new Vertex(1);
        Vertex v2= new Vertex(2);
        Vertex v3= new Vertex(3);
        Vertex v4= new Vertex(4);
        Vertex v5= new Vertex(5);
        Vertex v6= new Vertex(6);
        g.addEdge(v1,v2);
        g.addEdge(v2,v1);
        g.addEdge(v1,v3);
        g.addEdge(v3,v1);
        g.addEdge(v2,v4);
        g.addEdge(v4,v2);
        g.addEdge(v3,v5);
        g.addEdge(v5,v3);
        g.addEdge(v4,v6);
        g.addEdge(v6,v4);
        g.addEdge(v5,v6);
        g.addEdge(v6, v5);

        g.printGraph();

        DfsPaths d = new DfsPaths();
        d.dfs(g,v1,v2);

        if(d.dfsPathSet.size()==0) System.out.println("no path");
        else {

            for (Set<Vertex> currDfsPath : d.dfsPathSet) {
                System.out.println();
                for (Vertex v : currDfsPath) {
                    System.out.print(v.data + " ");
                }
            }
        }


    }
}
