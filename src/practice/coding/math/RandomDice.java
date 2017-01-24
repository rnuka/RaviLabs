package practice.coding.math;

import java.util.Random;

public class RandomDice {
    public RandomDice() {
    }
    
    public void randomNumber(int low, int high){
        //low and high are range for random numbers
        Random random = new Random();
        int max=6;
        int min=1;
        int d1=0,d2=0;
        while(d1 !=1 && d2 !=1){
           d1 = random.nextInt(max - min + 1) + min;
           d2 = random.nextInt(max - min + 1) + min;
           System.out.println("current run d1="+d1+" and d2="+d2);
        }
        System.out.println("now it is 1 on both dice");
       
        
    }
}
