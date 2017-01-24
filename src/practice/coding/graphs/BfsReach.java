package practice.coding.graphs;

/**
 * Created by rnuka on 6/13/16.
 */
import java.util.*;

public class BfsReach {

    public void bfs(Map<Integer,List<Integer>> adjList, int root, int nodeCount){
        int[] nodeLenArr = new int[nodeCount];
        boolean[] visitedNodes = new boolean[nodeCount];

        //bfs and calculate lengths
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(root);
        queue.add(null); //level change indicator
        int edgeLength = 0;
        Integer prevNode = null;
        while(!queue.isEmpty()){

            Integer currNode = queue.remove();

            //exit if list is over
            if(currNode == null && prevNode == null){
                break;
            }

            //Otherwise do bfs
            if(currNode != null){
                nodeLenArr[currNode-1]=edgeLength;
                List<Integer> edgeList = adjList.get(currNode);
                if(edgeList != null) {
                    //populate edge length for all edgeList
                    for (Integer curr : edgeList) {
                        //if not yet visited
                        if(!visitedNodes[curr-1]){
                            queue.add(curr);
                            visitedNodes[curr-1]=true;
                        }
                    }
                }
            }else{
                edgeLength = edgeLength+6;
                queue.add(currNode);
            }
            prevNode = currNode;
        }

        //print output
        for(int i=0;i<nodeCount; i++){
            if(i != root-1){
                nodeLenArr[i] = nodeLenArr[i]==0 ? -1: nodeLenArr[i];
                if(i != nodeCount-1){
                    System.out.print(nodeLenArr[i]+" ");
                }else{
                    System.out.print(nodeLenArr[i]);
                }
            }
        }


    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int i=0; i<testCases; i++){
            int nodeCount = sc.nextInt();
            int edgeCount = sc.nextInt();
            Map<Integer, List<Integer>> adjList = new HashMap<Integer,List<Integer>>();

            //read edges
            for(int j=0; j<edgeCount; j++){
                int fromNode = sc.nextInt();
                int toNode = sc.nextInt();
                if(adjList.containsKey(fromNode)){
                    List<Integer> edgeList = adjList.get(fromNode);
                    edgeList.add(toNode);
                }else{
                    List<Integer> edgeList = new ArrayList<Integer>();
                    edgeList.add(toNode);
                    adjList.put(fromNode, edgeList);
                }

                //now flip from and toNodes
                if(adjList.containsKey(toNode)){
                    List<Integer> edgeList = adjList.get(toNode);
                    edgeList.add(fromNode);
                }else{
                    List<Integer> edgeList = new ArrayList<Integer>();
                    edgeList.add(fromNode);
                    adjList.put(toNode, edgeList);
                }
            }

            //read root
            int root = sc.nextInt();

            //invoke function to print results
            BfsReach sol = new BfsReach();
            sol.bfs(adjList, root, nodeCount);
            System.out.println("");
        }
    }
}
