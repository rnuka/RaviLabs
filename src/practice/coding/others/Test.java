package practice.coding.others;

/**
 * Created by rnuka on 4/18/16.
 */
public class Test {

    public static void modify(Integer[] temp){
        for(int i=0;i<temp.length; i++){
            temp[i]=temp[i]+10;
        }
        for(int j:temp){
            System.out.println("ivalue="+j);
        }

    }

    public static void main(String args[]){
        Integer[] a = {1,2,3};
        modify(a);
        for(int j:a){
            System.out.println("value="+j);
        }

    }
}
