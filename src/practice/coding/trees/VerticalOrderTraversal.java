package practice.coding.trees;

import java.util.*;

/**
 * Created by rnuka on 12/2/16.
 */
/*
Question: Vertical Order Traversal
Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9


The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
 */
public class VerticalOrderTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int v){
            val = v;
        }
    }


    public Map<Integer, List<Node>> verticalTraversal(Node root){
        Map<Integer, List<Node>> results = new TreeMap<>();
        verticalTraversal(root, results,0);
        return results;
    }

    private void verticalTraversal(Node root, Map<Integer, List<Node>> results, int pos){
        if(root==null){
            return;
        }
        //update results
        if(results.containsKey(pos)){
            results.get(pos).add(root);
        }else{
            List<Node> levelNodes = new LinkedList();
            levelNodes.add(root);
            results.put(pos,levelNodes);
        }

        //traverse
        if(root.left != null){
            verticalTraversal(root.left, results, pos-1);
        }
        if(root.right != null){
            verticalTraversal(root.right, results, pos+1);
        }

    }

    public void printTree(Map<Integer, List<Node>> results){

        for(Map.Entry<Integer,List<Node>> currNodes: results.entrySet()){
            System.out.print("At key:: " + currNodes.getKey() + " Nodes are::: ");
            for(Node curr:currNodes.getValue()){
                System.out.print(curr.val);
            }
            System.out.println("");
        }
    }

    public void testcase1(){
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);
        Node n7= new Node(7);
        Node n8= new Node(8);
        Node n9= new Node(9);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        n6.right=n8;
        n7.right=n9;

        Map<Integer, List<Node>> results= verticalTraversal(n1);
        printTree(results);
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        VerticalOrderTraversal vt = new VerticalOrderTraversal();
        vt.testbed();
    }

}
