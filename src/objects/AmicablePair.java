package objects;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by crathinasababathy on 4/9/16.
 * 2.7.8
 Write code in file AmicablePair.java
 Print the CPU time using the procedure
 public double timeInSec(long endTime, long startTime)
 which is in IntUtil.java
 */
public class AmicablePair {

    // Sum of Proper Divisors

    public static int sumOfPD(int input){
        int maxD = (int)Math.sqrt(input); // till sq root instead of n/2
        int sum=1;
        for(int i = 2; i <= maxD; i++)
        {
            if(input % i == 0)
            {
                sum += i;
                int d = input/i;
                if(d!=i)
                    sum+=d;
            }
        }
        return sum;
    }


    public static void amicable(int n){
        int sum1 =0,sum2=0,val=0;
        long startTime = System.nanoTime();
        Set<Integer> set = new HashSet<Integer>();
        int counter=0;
        String fileName = "AmicablepairOutput.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("The following are amicable numbers \n");
            for (int i = 1; i < n; i++) {
                if (!set.contains(i)) {
                    sum1 = sum2 = val = 0;
                    sum1 = sumOfPD(i);
                    if (sum1 < 100000000 && sum1 != i) {
                        sum2 = sumOfPD(sum1);
                        if (sum2 == i) {
                            System.out.println("Amicable pairs:" + i + ":" + sum1);
                            fileWriter.write(counter++ +":" + i + " and " + sum1 +"\n");
                            set.add(sum1);
                            set.add(sum2);
                        }
                    }
                }
            }

            long endTime = System.nanoTime();

            System.out.println("Time in sec:" + new IntUtil().timeInSec(endTime, startTime));
            fileWriter.write("Time in sec:" + new IntUtil().timeInSec(endTime, startTime));
            fileWriter.close();
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("IO Exception");
        }
    }

    public static void main(String args[]){
       int n= 100000000;
        amicable(n);
    }
}

