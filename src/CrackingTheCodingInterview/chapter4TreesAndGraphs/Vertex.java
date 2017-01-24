package CrackingTheCodingInterview.chapter4TreesAndGraphs;

/**
 * Created by rnuka on 10/17/15.
 */
public class Vertex {
    int data;
    String state;

    public enum State{
        Unvisited, Visited, Visiting;
    }

    public Vertex(int d){
        this.data = d;
        this.state = State.Unvisited.toString();
    }
}
