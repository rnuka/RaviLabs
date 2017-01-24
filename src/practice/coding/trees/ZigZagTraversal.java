package practice.coding.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rnuka on 12/2/16.
 */
/*
*
* Print a binary tree in zig zag way (or spiral way)... that is:
......a.........
....b....c.......
..d...e...f...g..
.h.i.j.k.l.m.n.o.

should be printed as a-c-b-d-e-f-g-o-n-m-l-k-j-i-h

* */
public class ZigZagTraversal {


    public String printSpiralTraversal(Node root){
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        StringBuilder output = new StringBuilder("");

        boolean leftToRight = true;
        int index=0;
        while(!queue.isEmpty()){

            Node curr = queue.poll();

            if(curr==null){
                if(!queue.isEmpty()) {
                    output.append("\n");
                    queue.add(curr);
                }
                if(leftToRight){
                    index=output.length();
                }
                leftToRight = !leftToRight;

            }else {
                if (leftToRight) {
                    output.append(curr.data + " ");
                } else {
                    output.insert(index, curr.data + " ");
                }
                //Add if valid childs
                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }
            }



        }
        return output.toString();
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

        System.out.println(printSpiralTraversal(n1));;
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        ZigZagTraversal zt = new ZigZagTraversal();
        zt.testbed();
    }
}
