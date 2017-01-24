package practice.coding.linkedList;

public class LinkedListLoop {

    public LinkedListLoop() {
    }
    
    public boolean isLoopExist( Node head){
        Node slowRunner=head;
        Node fastRunner=head;
        while(fastRunner != null && fastRunner.next != null){

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if(fastRunner == slowRunner){
                System.out.println("fastRunner.data="+fastRunner.data);
                return true;
            }

        }
        return false;
    }

    public Node loopStartNode( Node head){
        Node slowRunner = head;
        Node fastRunner = head;
        while(fastRunner != null && fastRunner.next != null){

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if(fastRunner == slowRunner){
                System.out.println("fastRunner.data="+fastRunner.data);
                break;
            }

        }

        //If there is no loop
        if(fastRunner == null || slowRunner == null){
            return null;
        }

        //If loop exists move slow to head and start fast from looplenth-k at same speed
        slowRunner = head;
        while(slowRunner != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
            if(slowRunner == fastRunner){
                return fastRunner;
            }
        }

        return fastRunner;
    }
    
    public static void main(String[] args){
        LinkedListLoop listLoop = new LinkedListLoop();

        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n6= new Node(6);
        Node n7= new Node(7);
        
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n4);
        
        
        
        System.out.println("Does Loop Exist? ANS::" + listLoop.isLoopExist(n1));
        System.out.println("Does Loop start node? ANS::"+listLoop.loopStartNode(n1).data);

    }
}
