package practice.coding.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rnuka on 10/18/15.
 */

/*
Uber interview question to Chandra:

Question:  Print path lengths from root to leaf nodes which will match to given sum (in below example sum=19)


                    5
            4                 3
      10        15        11      20


  19

  5 4 10
  5 3 11


 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
input: root node and sum length
output: List of all possible paths
*/
public class PathLengths {


    public List<List<Node>> sumPaths(Node root, int remainingLength) {
        List<List<Node>> pathSet = new ArrayList();
        ArrayList<Node> currentPath = new ArrayList<Node>();
        sumPaths(root, remainingLength,currentPath,pathSet);
        return pathSet;
    }

    private void sumPaths(Node root, int remainingLength, ArrayList<Node> currentPath, List<List<Node>> results){

        if(root == null){
            return;
        }

        //add current root to path
        currentPath.add(root);


        //if leaf node is reached and sum of path matched
        if(root.left == null && root.right == null && (remainingLength-root.data == 0)){
            System.out.println("sum matched");
            results.add((ArrayList<Node>) currentPath.clone());
        }


        sumPaths(root.left, (remainingLength - root.data), currentPath, results);
        sumPaths(root.right, (remainingLength - root.data), currentPath, results);

        //remove above added node from list
        currentPath.remove(root);
    }

    public void printLevelOrder(Node root){
        Queue<Node> myQueue = new LinkedList<Node>();
        myQueue.add(root);
        myQueue.add(null);
        //while queue is not empty, traverse in bfs approach
        while(!myQueue.isEmpty()){
            Node curr = myQueue.remove();

            //if null node comes which is level change indicator
            // then insert null at back if queue has still some elements
            if(curr == null ){
                if( !myQueue.isEmpty()) {
                    myQueue.add(curr);
                }
                System.out.println("");
            }else{
                //print level
                System.out.print(curr.data + " ");
                //otherwise add left and right childs to the queue
                if(curr.left != null){
                    myQueue.add(curr.left);
                }
                if(curr.right != null){
                    myQueue.add(curr.right);
                }
            }


        }

    }

    //test
    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(7);
        Node n6 = new Node(11);
        Node n7 = new Node(5);
        Node n8 = new Node(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;
        n3.right= n6;
        n3.left = n7;
        n2.right = n8;

        PathLengths pl = new PathLengths();
        pl.printLevelOrder(n1);
        List<List<Node>> pathSet  = pl.sumPaths(n1, 15);

        //print paths
        for(List<Node> path: pathSet){
            System.out.println("----");
            for(Node n : path){
                System.out.print(n.data+"->");
            }
            System.out.println("");
        }
    }

}
