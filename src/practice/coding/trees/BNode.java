package practice.coding.trees;

public class BNode implements Comparable<BNode> {
    
    private BNode left;
    private BNode right;
    
    private Object data;

    //Constructor
    public BNode(Object val) {
        data = val;
    }

    //compareTo
    public int compareTo(BNode that){
        if((Integer)this.getData() < (Integer)that.getData()) return -1;
        if(this.getData() == that.getData()) return 0;
        else return 1;
    }


    public Object  getData(){
        return data;
    }

    public void setData(Object o){
        data = o;
    }

    public BNode getLeft(){
        return left;
    }

    public void setLeft(BNode left){
        this.left=left;
    }

    public BNode getRight(){
        return right;
    }

    public void setRight(BNode right){
        this.right=right;
    }


    
}
