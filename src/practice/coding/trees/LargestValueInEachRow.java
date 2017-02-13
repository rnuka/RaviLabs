package practice.coding.trees;

import javax.swing.tree.TreeNode;
import java.util.List;
import java.util.ArrayList;

/*
Question:

Find Largest Value in Each Tree Row
You need to find the largest value in each row of a binary tree.

Example:
Input:

          1
         / \
        3   2
       / \   \
      5   3   9

Output: [1, 3, 9]
 */
public class LargestValueInEachRow {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> results = new ArrayList<>();
        if (root != null) {
            largestValues(root, 0, results);
        }
        return results;
    }


    private void largestValues(TreeNode root, int currLevel, List<Integer> results) {
        //check if currLevel has value already
        if (results.size() == currLevel) {
            results.add(root.val);
        } else if (results.get(currLevel) != null && results.get(currLevel) < root.val) {
            results.set(currLevel, root.val);
        }

        if (root.left != null) {
            largestValues(root.left, currLevel + 1, results);
        }
        if (root.right != null) {
            largestValues(root.right, currLevel + 1, results);
        }

    }
}
