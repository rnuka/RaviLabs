package practice.coding.randomNumbers;

import java.util.Random;

/*
Approach: https://www.quora.com/How-do-you-design-a-rand7-function-using-a-rand5-function
 */
public class Rand7UsingRand5 {
    //Generate rand2() using rand5() with an assumption that rand5() generates between 0 to 4 and and rand2() should consider
    //values only when rand5() has values between 0,1,2,3 (for uniform distribution)
    //set 3 bits for rand7 and calculate value if rand7 is 7 then repeat rand7 calc again

    static int rand7(){
        int x = rand2()+2*rand2()+4*rand2();
        if(x==7){
            return rand7();
        }else {
            return x;
        }
    }

    static int rand2(){
        int x;
        while((x = rand5()) ==4){
            return x%2;
        }
        return x%2;
    }

    //Assume predefined rand5 function already provided (like below)
    static int rand5(){
        int max = 4;
        int min = 0;
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }

    public static void main(String[] args){
        for(int i=0; i<10; i++) {
            System.out.println("current value of rand5 is ::"+rand7());
        }
    }
}
