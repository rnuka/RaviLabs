package CrackingTheCodingInterview.chapter3StacksAndQueues;

/**
 * Created by rnuka on 10/15/15.
 */
public class MyStack {

    Node top;

    //push
    void push(Object data){
        if(top ==  null){
            top = new Node((Integer)data);
        }else{
            Node n = new Node((Integer)data);
            n.next = top;
            top = n;
        }
    }

    //pop
    Integer pop(){
        if(top != null){
            int popVal = top.data;
            top = top.next;
            return popVal;
        }
        return null;
    }

    //peek
    Integer peek(){
        if(top != null){
            return top.data;
        }
        return null;
    }

    //test
    public static void main(String[] args){
        MyStack s = new MyStack();
        s.pop();
        System.out.println("peek=" + s.peek());
        s.push(1);
        System.out.println("peek=" + s.peek());
        s.push(2);
        System.out.println("peek=" + s.peek());
        s.push(3);
        System.out.println("peek=" + s.peek());
        s.pop();
        System.out.println("peek=" + s.peek());
    }

}
