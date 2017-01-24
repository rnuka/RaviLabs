package objects;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by crathinasababathy on 4/9/16.
 * 1. 1.9.2

 You need to write code in file FakeGold70.java

 Assume that the fake coin is in position 4.
 1. Your code must print how many weighing you took to find this coin?
 2. Then you print what weighing you did to arrive this solution

 Run the above procedure assuming that the fake coin is in position 0 to 69.
 What is the minimum and maximum weighing you require?
 */

public class FakeGold70 {

    public static int weight ( int[] coinsArr, int fromIndex, int toIndex){
        int sum=0;
        for( int i=fromIndex; i <=toIndex; i++){
            sum += coinsArr[i];
        }
        return sum;
    }

    public static void main(String args[]){
        int[] coins = new int[70];
        int fromIndex =0, toIndex=69;

        int low =0, high=coins.length-1, mid=0, counter=0;
        int leftWeight=0, rightWeight=0, midWeight=0;
        int[] output = new int[70];

        int weighs=0;
        int fakeCoin=0; // -1 is lighter, 1 is heavier

        // outer loop to iterate and place the fake coins in all positions

        for( int i=fromIndex; i <= toIndex; i++){

            fakeCoin  = counter =leftWeight = midWeight = rightWeight= 0;
            weighs = 0;

            if(i>=1) coins[i-1]=0; //just resetting the last placed fake coin

            coins[i] = -1; //putting the fake coin in i-th position


            low = 0; high = 69;

            while ( low < high){

                weighs++;
                mid = (low + high)/2;
                if ((low+high+1) % 2 == 0)
                {
                    leftWeight = weight(coins, low, mid);
                    rightWeight = weight(coins, mid+1, high);
                } else{
                    leftWeight = weight(coins, low, mid-1);
                    midWeight = weight(coins,mid,mid);
                    rightWeight = weight(coins, mid+1, high);
                }

                //assume the logic fakecoin is lighter and traverse the left sub tree
                if (leftWeight < rightWeight){
                    high = mid;
                } else if( leftWeight > rightWeight){
                    low = mid+1;
                }else{ // equals case
                    low = high;
                }

                //assume fake coin is heavier
                /*    if (leftWeight > rightWeight){
                        high = mid;
                    } else if( leftWeight < rightWeight){
                        low = mid+1;
                    }else{ // equals case
                        low = high;
                    }
                */
            }
            output[i] = weighs;
        }

        String fileName = "FakeGold70_Output.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
        for( int j=fromIndex; j<=toIndex; j++){
            System.out.println("Fake Coin:" + j + " took " + output[j] + " weighs");
            fileWriter.write("Fake Coin:" + j + " took " + output[j] + " weighs \n");
        }
        fileWriter.close();
    } catch(IOException e){
        e.printStackTrace();
        System.out.println("IO Exception");
    }

    }

}