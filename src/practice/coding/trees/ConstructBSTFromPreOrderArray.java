package practice.coding.trees;

/*
Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50
 */
public class ConstructBSTFromPreOrderArray {
    Node buildBST(int[] input){
        if(input == null){
            return null;
        }
        Node root = new Node(input[0]);

        for(int i=1; i<input.length; i++){
            insert(input[i], root);
        }
        return root;

    }

    void insert(int newVal, Node root){
        Node curr = root;
        if(curr.data < newVal){
            if(curr.right == null){
                curr.right = new Node(newVal);
            }else{
                insert(newVal, root.right);
            }
        }else{
            if(curr.left == null){
                curr.left = new Node(newVal);
            }else{
                insert(newVal, root.left);
            }
        }
    }

    public void testcase1(){
        int[] input =  {10, 5, 1, 7, 40, 50};
        Node root = buildBST(input);
        root.inOrderTraversal();
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String[] args){
        ConstructBSTFromPreOrderArray c = new ConstructBSTFromPreOrderArray();
        c.testbed();
    }
}
