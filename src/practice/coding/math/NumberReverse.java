package practice.coding.math;

public class NumberReverse {
    public int reverse = 0;
    public int reverse(int number) {
        int remainder = number%10;
        reverse = reverse*10 + remainder;
        int d = number/10;
        if(d>0){
            reverse(d);
        }
        return reverse;
    }
}
