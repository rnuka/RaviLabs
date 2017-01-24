package practice.coding.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rnuka on 10/5/15.
 */
public class GraphAdjList {
    public Map<GNode,Map<GNode,Integer>> graph;

    public GraphAdjList(){
        graph = new HashMap<GNode,Map<GNode,Integer>>();
    }

    public void addEdge(GNode fromGNode, GNode toGNode, Integer weight){
        if(graph.get(fromGNode) != null) {
            if(graph.get(fromGNode).get(toGNode) != null)
                graph.get(fromGNode).put(toGNode,weight);
        }
        else{
            Map<GNode, Integer> currAdjList = new HashMap<GNode,Integer>();
            currAdjList.put(toGNode,weight);
            graph.put(fromGNode,currAdjList);
        }
    }

    public void printGraph(){
        for(Map.Entry<GNode,Map<GNode,Integer>> currAdjList : graph.entrySet()){
            for(Map.Entry<GNode,Integer> adjancentNode :currAdjList.getValue().entrySet()){
                System.out.println(currAdjList.getKey().nodeValue+"->"+adjancentNode.getKey().nodeValue+" weight::"+adjancentNode.getValue());
            }
        }
    }

    public int size(){
        return graph.size();
    }
}
