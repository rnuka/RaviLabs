package practice.coding.trees;

/*

Question: Find Bottom Left Tree Value
--------
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
----------
Input:

    2
   / \
  1   3

Output:
1

Example 2:
----------
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
 */

public class BottomLeftValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        int[] result = new int[2];
        //0 index for result, 1 index for level
        result[1] = -1;
        findBottomLeftValue(root, result, 0);
        return result[0];
    }

    private void findBottomLeftValue(TreeNode root, int[] result, int currLevel){
        if(currLevel > result[1]){
            result[0] = root.val;
            result[1] = currLevel;
        }
        if(root.left != null){
            findBottomLeftValue(root.left, result, currLevel+1);
        }
        if(root.right != null){
            findBottomLeftValue(root.right, result, currLevel+1);
        }

    }
}
