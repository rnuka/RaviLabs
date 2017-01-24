package practice.coding.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * In BFS:
 * Input: Grapg G(V,E) and start vertex s belongs to V
 * Output: Print all vertices reachable from s
 * 
 */

public class BFS {
    
   // static Map<Character, List<Character>> graph;
    
    static int sourceVertex = '1';
    
    public BFS(){
        //graph = new HashMap<Integer,List<Integer>>();
    }

    
    //queue to hold elements and populate with root element
    static GNode[] graphQueue={};
    
    public void bfs(Graph g){
    
       //dequeue the first element in queue and see if there are any
       GNode currNode;
       while(graphQueue.length > 0){
           
           //dequeue frist element
           currNode=deQueue(g);
           graphQueue = Arrays.copyOf(graphQueue,graphQueue.length-1);
           
           //get edges of current node
           List edgeList = g.getEdgesList(currNode);
           Iterator iter = edgeList.iterator();
           for(int i=0;i<edgeList.size();i++){
               GNode toNode = (GNode)edgeList.get(i);
           }
           
       }
        
    }
    
    //dequeue the queue's first element
    public GNode deQueue(Graph g){
    
       GNode root = graphQueue[0];
       
       //bring all elements to front in the queu
       for (int i=0;i<graphQueue.length;i++){
          graphQueue[i] = graphQueue[i+1];
       }
       
       //free up the memory of last element in queue
       graphQueue = Arrays.copyOf(graphQueue, graphQueue.length-1);
       
       return root;
        
    }
    
    //enqueue the element into queue
    public void enQueue(GNode node){
        //add memory at the end
        graphQueue = Arrays.copyOf(graphQueue, graphQueue.length+1);
        graphQueue[graphQueue.length] = node;
    }
    
    
    
    public static void main(String args[]){
        
        //Construct graph with adjacency lists where A is not reachable to X, Y, Z
        
        Graph graph = new Graph();
        
        //Define Vertices
        GNode N1 = new GNode(1);
        GNode N2 = new GNode(2);
        GNode N3 = new GNode(3);
        GNode N4 = new GNode(4);
        GNode N5 = new GNode(5);
        
        
        //Add edges
        graph.addEdge(N1,N2);
        graph.addEdge(N1,N3);
        graph.addEdge(N2,N3);
        graph.addEdge(N2,N4);
        graph.addEdge(N3,N5);
        
        
        System.out.println("no of edges:"+graph.edgesCount());
        
        graph.printGraph();
        
        //start bfs with source node in queue
         graphQueue[0]=N1;
        
       
        
        
    }
}
