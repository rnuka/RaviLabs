package practice.coding.graphs;

import java.util.List;
public class GNode {
    int nodeValue;
    
    
    boolean visited;
    List<Integer> edges;
    public GNode next;
    public GNode() {
         
    }
    
    public GNode(int val){
        nodeValue = val;
    }
    
    public int getVal(){
       return nodeValue; 
    }
    
    @Override
    public boolean equals(Object other){
        GNode dest = (GNode)other;
        if(this.getVal()== dest.getVal())
           return true;
        else
           return false;
    }
    
    @Override
    public int hashCode(){
        int hashCode=1;
        hashCode= hashCode*37+this.getVal();
        return hashCode;
    }
}
