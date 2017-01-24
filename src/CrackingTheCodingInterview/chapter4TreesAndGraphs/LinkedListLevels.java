package CrackingTheCodingInterview.chapter4TreesAndGraphs;

import java.io.*;
import java.util.*;

/*
4.4 Given a binary tree, design an algorithm which creates a linked list of all the
nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked
lists).
*/

class LinkedListLevels {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //method to take binary tree input and give list of linkedlists
    public static List<LinkedList<Node>> treeLists(Node root){
        //Traverse Level by Level and pass null object as indicator
        Queue<Node> queue = new LinkedList<Node>();

        Node indicator = null;
        queue.add(root);
        queue.add(null);
        List<LinkedList<Node>> returnList = new ArrayList<LinkedList<Node>>();

        //buffer
        LinkedList<Node> ls = new LinkedList<Node>();
        Node prev = null;
        Node curr = null;
        //loop through all nodes
        while(!queue.isEmpty()){

            curr = queue.remove();

            //level change indicator
            if(curr != null){
                //add to buffer
                ls.add(curr);

                if(curr.left != null){
                    //insert left
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    //insert right
                    queue.add(curr.right);
                }
            }else{

                //place indicator at the end again
                if(prev != null){
                    LinkedList<Node> temp = new LinkedList<Node>();
                    temp.addAll(ls);
                    returnList.add(temp);
                    //empty buffer to track next level children
                    ls.clear();
                    queue.add(indicator);
                }

            }

            prev = curr;

        }

        return returnList;

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n3.right = n5;
        n5.right = n6;
        List<LinkedList<Node>> output = new ArrayList<LinkedList<Node>>();
        output = treeLists(null);

        for ( LinkedList<Node> l : output){
            for( Node curr : l){
                System.out.print(curr.data + "->");
            }
            System.out.println("done");
        }
        System.out.println("End");
    }
}

