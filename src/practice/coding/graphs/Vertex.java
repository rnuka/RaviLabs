package practice.coding.graphs;

/**
 * Created by rnuka on 9/23/15.
 */
public class Vertex implements Comparable<Vertex> {
    public int data;
    public int weight;
    public boolean visited;
    public Vertex(int data){
        this.data = data;
    }

    public boolean equals(Object o){
        Vertex that = (Vertex)o;
        if (this.data == that.data) return true;
        else return false;
    }

    public int compareTo(Vertex other){
        if(this.data < other.data) return -1;
        if(this.data == other.data) return 0;
        else return 1;
    }


}
