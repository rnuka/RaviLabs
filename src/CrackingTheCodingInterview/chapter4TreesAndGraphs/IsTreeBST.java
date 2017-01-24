package CrackingTheCodingInterview.chapter4TreesAndGraphs;
/* 4.5 Implement a function to check if a binary tree is a binary search tree.

public boolean checkBT(Node node){

}

root is between left and right..
max(left)<root<min(right)
       5
  3         6
2  4    7      8
TRUE

       5
  3         6
2  10    7      8
FALSE

*/
public class IsTreeBST {
    public static boolean isBSTUtil(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max));
    }

}