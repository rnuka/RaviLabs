package practice.coding.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rnuka on 6/15/16.
 */
/*
* Given a graph with adjacency list and root node, print how many children are present under each node.
* */

public class ChildCounts {

    public Map<GNode, Integer> countChilds(Map<GNode, List<GNode>> edges, GNode root){
        Map<GNode, Integer> results = new HashMap<GNode, Integer>();
        countChilds(edges, results, root);
        return results;
    }

    private int countChilds(Map<GNode, List<GNode>> edges, Map<GNode, Integer> results, GNode root){

        //null case
        if(root == null){
            return 0;
        }

        //base case
        if(!edges.containsKey(root)){
            results.put(root, 0);
            return 0;
        }

        List<GNode> edgesList = edges.get(root);
        int total = 0;
        for(int i=0; i< edgesList.size(); i++){
            int childCount = countChilds(edges, results, edgesList.get(i));
            System.out.println("children under parent::"+root.getVal()+" and child tree "+edgesList.get(i).getVal()+" is::"+childCount);
            total += childCount+1;
        }

        System.out.println("****children  under root::"+root.getVal()+" is::"+total);

        results.put(root, total);
        return total;

    }

    public static void main(String args[]){
        ChildCounts cc = new ChildCounts();
        //Construct graph with adjacency lists where A is not reachable to X, Y, Z

        Map<GNode, List<GNode>> edges = new HashMap<GNode, List<GNode>>();

        //Define Vertices
        GNode N1 = new GNode(1);
        GNode N2 = new GNode(2);
        GNode N3 = new GNode(3);
        GNode N4 = new GNode(4);
        GNode N5 = new GNode(5);
        GNode N6 = new GNode(6);
        GNode N7 = new GNode(7);

        List<GNode> edgeList1 = new ArrayList<>();
        List<GNode> edgeList2 = new ArrayList<>();
        List<GNode> edgeList3 = new ArrayList<>();

        edgeList1.add(N2);
        edgeList1.add(N3);
        edges.put(N1, edgeList1);

        edgeList2.add(N4);
        edgeList2.add(N5);
        edges.put(N2, edgeList2);

        edgeList3.add(N6);
        edgeList3.add(N7);
        edges.put(N3,edgeList3);

        Map<GNode, Integer> results = cc.countChilds(edges,N1);

        for(Map.Entry<GNode,Integer> entry : results.entrySet()){
            System.out.println("for Node "+entry.getKey().nodeValue+" child count is "+entry.getValue());
        }


    }


}
