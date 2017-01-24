package practice.coding.graphs;

import java.util.*;

/**
 * Created by rnuka on 5/2/16.
 */
/*
* There are Jobs which spawn child jobs and then child jobs may spawn further child jobs or not.
* Write a program to return each Job and respective child jobs underneath it.
*
* Input: Graph G with List of Edges
*     Graph G : List<Edge>
*     Edge: <Node, Node> (FromNode -> ToNode)
* Output: Map<Node,totalChildJobsUnderIt>
* Assumption: Acyclic Graph
* */
public class JobDependency {
    static class Node{
        int value;
        boolean visited;
        public Node(int val){
            value = val;
            visited = false;
        }
    }
    static class Edge{
        Node fromVertex;
        Node toVertex;
        public Edge(Node from, Node to){
            fromVertex = from;
            toVertex = to;
        }
    }
    static class Graph{
        List<Edge> edgeList;
        public Graph() {
            edgeList = new ArrayList<Edge>();
        }
        public void addEdge(Edge e){
            edgeList.add(e);
        }
    }
    //preprocessing step - to convert given graph into adjacency list
    public Map<Node,Set<Node>> prepareAdjancencyList(Graph graph){
        Map<Node, Set<Node>> adjancencyList = new HashMap<Node,Set<Node>>();
        for(Edge edge: graph.edgeList){
            if(adjancencyList.containsKey(edge.fromVertex)){
                adjancencyList.get(edge.fromVertex).add(edge.toVertex);
            }else{
                Set<Node> edgeSet = new HashSet<Node>();
                edgeSet.add(edge.toVertex);
                adjancencyList.put(edge.fromVertex,edgeSet);
            }
        }
        return adjancencyList;
    }
    private void resetGraphVisited(Graph graph){
        for (Edge e: graph.edgeList){
            e.fromVertex.visited=false;
            e.toVertex.visited=false;
        }

    }
    private Map<Node,Integer> calculateDependencies(Graph graph){

        Map<Node, Integer> results = new HashMap<Node, Integer>();

        //invoke preprocessor and get adjacency list
        Map<Node, Set<Node>> adjancencyList = prepareAdjancencyList(graph);


        //for each Node get the child jobs underneath it by dfs or bfs
        for(Map.Entry adjEntry: adjancencyList.entrySet()){
            resetGraphVisited(graph);
            Integer count = bfs(adjancencyList,(Node)adjEntry.getKey());
            results.put((Node)adjEntry.getKey(),count);
        }
        return results;
    }

    private Integer bfs(Map<Node, Set<Node>> adjancencyList, Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            Node currNode = queue.remove();

            if(currNode != null && adjancencyList.get(currNode) != null) {
                System.out.println("currNode"+currNode.value);
                for (Node node : adjancencyList.get(currNode)) {
                    System.out.println("child of "+currNode.value+" is"+node.value);
                    if(!node.visited) {
                        count++;
                        queue.add(node);
                        node.visited=true;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Edge e1 = new Edge(n1, n2);
        Edge e2 = new Edge(n1, n3);
        Edge e3 = new Edge(n2, n4);
        Edge e4 = new Edge(n3, n5);
        Edge e5 = new Edge(n3, n2);
        Graph graph = new Graph();
        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        JobDependency dependencyCount = new JobDependency();
        Map<Node,Integer> results = dependencyCount.calculateDependencies(graph);

        for(Map.Entry entry: results.entrySet()){
            System.out.println("for node "+((Node)entry.getKey()).value+" dependency count is::"+entry.getValue());
        }
    }
}
