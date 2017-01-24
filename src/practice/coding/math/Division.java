package practice.coding.math;

public class Division {
    public static int a=60;
    public static int b=12;
    public static int min;
    public static int max;
    
    public Division() {
    }
    
    
    public static void main(String[] args){
       
    //call division method
    int val =division(a,b); 
    System.out.println("val="+val);
    }
    
    public static int division(int a, int b){
       int i=1;
       int counter=0;
       while(a>=b){
           a=a-b;
           counter++;
       }
        return counter;
    }
}
