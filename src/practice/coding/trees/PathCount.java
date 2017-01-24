package practice.coding.trees;

/**
 * Created by rnuka on 11/15/16.
 */
/*
* Question: For given binary tree ROOT and target Sum T, print total possible paths from root to leaf node
* that matches the target sum T
* */
public class PathCount {
    public int pathCount(Node root, int T){
        int totalPaths = 0;
        totalPaths = pathCount(root,T,0);
        return totalPaths;
    }

    private int pathCount(Node root, int T, int currentSum){
        if(root == null){
            return 0;
        }

        currentSum+=root.data;

        if(currentSum==T && root.left == null && root.right == null){
            return 1;
        }


        int leftPaths = pathCount(root.left, T, currentSum);
        int rightPaths = pathCount(root.right, T, currentSum);

        return (leftPaths+rightPaths);


    }


    public static void main(String[] args){

            PathCount p = new PathCount();


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

            System.out.println("total Paths ="+p.pathCount(n1,15));
    }

}
