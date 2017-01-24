package CrackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/*
4.1 Implement a function to check if a binary tree is balanced. For the purposes of
        this question, a balanced tree is defined to be a tree such that the heights of the
        two subtrees of any node never differ by more than one.
*/

/**
 * Created by rnuka on 10/16/15.
 */
public class IsTreeBalanced {

    //================ Bad solution where height of tree is calculated again n again =================
    boolean isTreeBalanced(Node root){

        //base case
        if(root == null){
            return true;
        }

        //if subtree are differ by length more than 1 then return faslse
        if( Math.abs(getHeight(root.left) - getHeight(root.right)) > 1 ){
            return false;
        }
        //else recurse childs to see if they are balanced
        else{
            return (isTreeBalanced(root.left)) && (isTreeBalanced(root.right));
        }
    }

    int getHeight(Node root){

        //base case
        if(root == null){
            return 0;
        }

        //others: compare left sub tree height and right sub tree height and add 1 for the current level
        return Math.max(getHeight(root.left), getHeight(root.right)) +1 ;

    }

    //===================== Optimized Solution ==========================

    public boolean isTreeBalanced2(Node root){
        return !(getHeight2(root)==-1);
    }

    private int getHeight2(Node root){
        if(root == null) {
            return 0;
        }
        int lstHeight = getHeight2(root.left);
        int rstHeight = getHeight2(root.right);
        if(lstHeight==-1 || rstHeight==-1|| Math.abs(lstHeight-rstHeight)>1){
            return -1;
        }
        return Math.max(lstHeight,rstHeight)+1;

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
    public static void main(String[] args) {



        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;
        n3.right= n6;
        n3.left = n7;
        n2.right = n8;
        n5.left=n9;

        IsTreeBalanced mt = new IsTreeBalanced();
        mt.printLevelOrder(n1);
        System.out.println("is tree balanced::" + mt.isTreeBalanced(n1));
        System.out.println("is tree balanced2::"+mt.isTreeBalanced2(n1));

    }
}
