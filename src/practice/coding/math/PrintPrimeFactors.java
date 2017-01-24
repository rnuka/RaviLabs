package practice.coding.math;

/*
Question: Given a number n, write an efficient function to print all prime factors of n.

Example-1: If the input number is 12, then output should be “2 2 3”.
----------

Example-2: if the input number is 315, then output should be “3 3 5 7”.
----------
 */

import java.util.ArrayList;
import java.util.List;

public class PrintPrimeFactors {

    public List<Integer> primeFactors(int n){
        List<Integer> results = new ArrayList<>();
        primeFactors(n, results);
        return results;
    }

    void primeFactors(int n, List<Integer> results){
        if(n <= 1){
            return;
        }
        int i;
        for(i=2; i<n/2; i++){
            if(n%i == 0 && isPrime(i)){
                results.add(i);
                break;
            }
        }
        if(n%i == 0 && isPrime(n/i) && (n/i) != 1){
            results.add(n/i);
        }
        primeFactors(n/i, results);

    }

    boolean isPrime(int k){
        for(int i=2; i <= k-1; i++){
            if(k%i == 0){
                return false;
            }
        }
        return true;
    }


    //Approach-2: Another readable approach
    List<Integer> primeFactors2(int n){
        List<Integer> results = new ArrayList<>();

        int i = 2;

        while(i <= n){
            if( n%i == 0){
                results.add(i);
                n = n/i;
            }else{
                i++;
            }
        }
        return results;
    }

    void testcase2(int n){
        System.out.println("prime factors of n="+n+" are::"+primeFactors2(n));
    }


    void testcase1(int n){
        System.out.println("prime factors of n="+n+" are::"+primeFactors(n));
    }

    void testbed(){
        testcase2(12);
        testcase2(315);
        testcase2(100);
        testcase1(10);
    }

    public static void main(String args[]){
        PrintPrimeFactors p = new PrintPrimeFactors();
        p.testbed();
    }


}
