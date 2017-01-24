package practice.coding.trees;

/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
Note: If the given node has no in-order successor in the tree, return null .
 */
/*
Time Complexity: O(h) where h is height of tree
 */
public class InOrderSuccessorBST {
    public Node inorderSuccessor(Node root, Node n){
        if(n.right !=null){
            return getMinimum(n.right);
        }

        Node successor = null;
        while(root !=null){
            if(root.data > n.data){
                successor = root;
                root = root.left;
            }else if(root.data < n.data){
                root = root.right;
            }else{
                break;
            }
        }
        return successor;
    }

    public Node getMinimum(Node root){
        if(root==null){
          return null;
        }
        if(root.left != null){
            return getMinimum(root.left);
        }
        return root;
    }
}
