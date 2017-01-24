package pinterest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rnuka on 12/1/16.
 */
/*
* Question from glass door:
* Given a set of pins with attributes (pin id, height),
* write a function that takes the argument 'k' (determining the number of columns) and
* inserts the pins such that every pin goes into a column with least consumed height.
* If there is a tie then insert into the left most column
*
* p1 (1,1), p2(2,2), p3(3,3), p4(4,4), p5(5,5)
*
* add(p1) ->  X
* add(p2) ->  XX
*              X
* add(p3) ->  XXX
*              XX
*               X
* add(p4) ->  XXX
*             YXX
*             Y X
*             Y
*             Y
* */
public class PlacePins  {

    int totalColumns;
    Queue<Column> board;

    public PlacePins(int totalColumns){
        this.totalColumns = totalColumns;
        /*board  = new PriorityQueue(totalColumns, new Comparator<Column>(){
            public int compare(Column c1, Column c2){
                if(c1.height==c2.height){
                    return c1.id-c2.id;
                }
                return c1.height-c2.height;
            }
        });*/

        board = new PriorityQueue<>(totalColumns, (c1,c2)->(c1.height-c2.height == 0 ? c1.id-c2.id : c1.height - c2.height));
    }

    //Pin object
    public static class Pin{
        int pid;
        int height;
        public Pin (int pid, int height){
            this.pid = pid;
            this.height = height;
        }
    }

    public static class Column{
        int id;
        int height;
        public Column(int id, int height){
            this.id = id;
            this.height = height;
        }
    }

    /**
     *
     * @param p
     */
    public Column addPin(Pin p){
        Column col;
        if(board.size() < totalColumns){
            col = new Column(board.size(),0);
        }else{
            col = board.poll();
        }
        col.height += p.height;
        board.add(col);
        return col;
    }

    public void myAssert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fails");
        }
    }

    public void testcase1(){

        Pin p1 = new Pin('a',1);
        Pin p2 = new Pin('b',2);
        Pin p3 = new Pin('c',3);
        Pin p4 = new Pin('e',4);
        Pin p5 = new Pin('d',5);

        Column col = addPin(p1);
        System.out.println("adding pin1 in column:" + col.id+" and height="+col.height);
        col = addPin(p2);
        System.out.println("adding pin2 in column:" + col.id+" and height="+col.height);
        col = addPin(p3);
        System.out.println("adding pin3 in column:" + col.id+" and height="+col.height);
        col = addPin(p4);
        System.out.println("adding pin4 in column:" + col.id+" and height="+col.height);
        col = addPin(p5);
        System.out.println("adding pin5 in column:" + col.id+" and height="+col.height);

    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        PlacePins pins = new PlacePins(3);
        pins.testbed();
    }


}
