package practice.coding.math;

public class SumOfDigits {

    public static int sum(int n){
        if(n==0){
            return 0;
        }
        System.out.println("n/10="+n/10+" n%10="+n%10);
        return n%10+sum(n/10);

    }

    public static void main(String args[]){
        int n = -1123;
        System.out.println("sum is::"+SumOfDigits.sum(n));
    }

}
