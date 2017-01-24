package practice.coding.others;

/**
 * Created by rnuka on 4/13/16.
 */
public class swap {

    Integer a =1;
    Integer b=2;


    public void swap(Integer x, Integer y){


        Integer c = new Integer(10);
         c = y;
        b = x;
        a = c;
        System.out.println("a=" + a + " and b=" + b);
        return;
    }

    public static void main(String args[]){
        swap s = new swap();
        System.out.println("a="+s.a+" and b="+s.b);
        int a = 10;
        int b=20;

        s.swap(a,b);
        System.out.println("a="+s.a+" and b="+s.b);

    }
}
