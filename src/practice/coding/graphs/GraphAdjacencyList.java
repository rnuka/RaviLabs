package practice.coding.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rnuka on 9/23/15.
 */
public class GraphAdjacencyList {

    public Map<Vertex,List<Vertex>> graph;

    public GraphAdjacencyList(){
        graph = new HashMap<Vertex,List<Vertex>>();
    }

    public void addEdge(Vertex fromVertex, Vertex toVertex){
        if(graph.get(fromVertex) != null) {
            graph.get(fromVertex).add(toVertex);
        }
        else{
            List<Vertex> currAdjList = new ArrayList<Vertex>();
            currAdjList.add(toVertex);
            graph.put(fromVertex,currAdjList);
        }
    }

    public void printGraph(){
        for(Map.Entry<Vertex,List<Vertex>> currAdjList : graph.entrySet()){
            for(Vertex adjancentNode:currAdjList.getValue()){
                System.out.println(currAdjList.getKey().data+"->"+adjancentNode.data);
            }
        }
    }

    public int size(){
        return graph.size();
    }
}
