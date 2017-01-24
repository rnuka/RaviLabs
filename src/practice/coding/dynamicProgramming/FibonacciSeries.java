package practice.coding.dynamicProgramming;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FibonacciSeries {
    public FibonacciSeries() {
    }


    //using DP for-loop (Most efficient)
    public static long fibonacciForLoop(int n){

        if(n<=0){
            return 0;
        }

        if(n==1){
            return 1;
        }

        long prev1 = 1L, prev2 = 0L, curr = 0L;

        for(int i=2; i<=n;i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
    
    private Map<Integer,Long> cache = new ConcurrentHashMap<Integer,Long>();
    
    //using dp recursion: (not efficient because of recursion)
    public long fibonacci(int n){
    
        //base cases
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        
        Long result = cache.get(n); 
        if(result==null){
            result = fibonacci(n-1)+fibonacci(n-2);
            cache.put(n,result);
        }
        return result;
    }


    //using tail recursion: (not efficient because of recursion)
    public static long tailRecursive(long n) {
        if (n <= 2) {
            return 1;
        }
        return tailRecursiveAux(0, 1, n);
    }

    private static long tailRecursiveAux(long a, long b, long count) {
        if(count <= 0) {
            return a;
        }
        return tailRecursiveAux(b, a+b, count-1);
    }

    //using normal recursion (Worst : because no memoization and not even tail recursion)
    public static long regularRecursionFibonacci(int n){
        if(n<=0){
            return 0;
        }

        if(n==1){
            return 1;
        }
        return regularRecursionFibonacci(n-1)+regularRecursionFibonacci(n-2);
    }



    public static void main(String args[]){
        FibonacciSeries fibonacciNumber = new FibonacciSeries();
        long startTime = 0L;
        long endTime = 0L;
        long elapsedTime = 0L;
        for(int n=20000; n<20010; n++) {
            System.out.println("-----Calculating Fibonacci value of n="+n+" ------");

            /* Fails if n is higher value - stackoverflow error
            startTime = System.currentTimeMillis();
            System.out.println("num using dp recursion" + fibonacciNumber.fibonacci(n));
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime);
            System.out.println("Time to complete::"+elapsedTime);
            */

            //is winner of efficiency : Always dp using for loop is efficient
            startTime = System.currentTimeMillis();
            System.out.println("num using for loop=" + fibonacciForLoop(n));
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime);
            System.out.println("Time to complete::"+elapsedTime);

            /* Fails if n is higher value - stackoverflow error
            startTime = System.currentTimeMillis();
            System.out.println("num using tail recursion=" + tailRecursive(n));
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime);
            System.out.println("Time to complete::"+elapsedTime);
            */
        }

        System.out.println("new sum"+(-8172440085091389503L+(-1724400850913895030L)));
    }
    
}
