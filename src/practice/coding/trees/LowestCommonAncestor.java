package practice.coding.trees;

/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

Example1: The lowest common ancestor (LCA) of nodes 5 and 1 is 3.
Example2: LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

* */
public class LowestCommonAncestor {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        if(root == null){
            return null;
        }else if(root==p){
            return p;
        }else if(root==q){
            return q;
        }else{
            boolean pIsOnLeft = covers(root.left, p);
            boolean qIsOnLeft = covers(root.left, q);
            //if p and q are on different sides
            if(pIsOnLeft != qIsOnLeft){
                return root;
            }else{
                Node nextRoot = pIsOnLeft ? root.left : root.right;
                return lowestCommonAncestor(nextRoot, p, q);
            }
        }

    }

    private boolean covers(Node root, Node target){
        if(root == null){
            return false;
        }else if(root==target){
            return true;
        }else{
            return covers(root.left,target) || covers(root.right, target);
        }
    }

    public static void main(String args[]){

    }
}
