package practice.coding.math;

 
public class BinaryCheck {
 
    public boolean isBinaryNumber(int binary){
         
        while(binary != 0){
            if(binary%10 > 1){
                return false;
            }
            binary = binary/10;
        }
        return true;
    }
     
    public static void main(String a[]){
        BinaryCheck mbc = new BinaryCheck();
        System.out.println("Is 1000111 binary? :"+mbc.isBinaryNumber(100011-1));
        System.out.println("Is 10300111 binary? :"+mbc.isBinaryNumber(10300111));
    }
}
