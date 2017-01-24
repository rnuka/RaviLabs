package CrackingTheCodingInterview.chapter3StacksAndQueues;

/**
 * Created by rnuka on 10/15/15.
 */
import java.util.Stack;
public class Tower {
    private Stack<Integer> disks;
    private int index;

    //constructor
    public Tower(int i) {
        disks = new Stack<Integer>();
        index = i;
    }

    //add element to tower
    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
            }
    }

    //return tower index
    public int index(){
        return index;
    }

    //move top



}
