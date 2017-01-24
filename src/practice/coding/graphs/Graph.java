package practice.coding.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Graph {
   
    private HashMap<GNode, List<GNode>> graph;

    public Graph() {
        graph = new HashMap<GNode, List<GNode>>();
    }
    
    private static  int verticesCount;
    private static int edgeCount;
    
    public void addEdge(GNode fromVertex, GNode toVertex){
    
        edgeCount++;
        if(graph.get(fromVertex) != null)
            graph.get(fromVertex).add(toVertex);
        else 
            {
                List ls = new ArrayList<Integer>();
                ls.add(toVertex);
                graph.put(fromVertex,ls);
            }
        
    }
    
    public ArrayList getEdgesList(GNode fromVetext){
        ArrayList edgeList = (ArrayList)graph.get(fromVetext);
        return edgeList;
    }
    
    public void removeEdge(GNode fromVertex, GNode toVertex){
        if(graph.get(fromVertex) != null)
            graph.get(fromVertex).remove(toVertex);
        else 
            {
                System.out.println("No such edge exists");
            }   
    }
    
    public int edgesCount(){
        return edgeCount;
    }
    
    public static void main(String args[]){
        Graph g = new Graph();
        GNode N1 = new GNode(1);
        GNode N2 = new GNode(2);
        
        g.addEdge(N1,N2);
        
        
        
        System.out.println("After adding");
        //print graph
        g.printGraph();
        
        
       
    }
    
    public void printGraph(){
        Iterator graphIter = graph.entrySet().iterator();
        while(graphIter.hasNext()){
            Map.Entry pair = (Map.Entry)graphIter.next();
            GNode fromNode = (GNode)pair.getKey();
            
            ArrayList edgeList = (ArrayList)pair.getValue();
            for(int i=0;i<edgeList.size();i++){
                GNode toNode = (GNode)edgeList.get(i);
                System.out.println(fromNode.getVal()+"->"+toNode.getVal());
            }
        }
    }
    
    public List<Integer> adjacentVertices(int fromVertex){
        List<Integer> adjVerticesList = new ArrayList<Integer>();
        if(graph.get(fromVertex) != null)
            adjVerticesList = (ArrayList)graph.get(fromVertex);
        return adjVerticesList; 
    }
}
