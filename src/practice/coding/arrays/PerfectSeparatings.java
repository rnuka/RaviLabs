package practice.coding.arrays;

import java.util.Scanner;

/*

see problem statement: https://www.hackerrank.com/contests/blackrock-codesprint/challenges/perfect-separating/submissions


* */
public class PerfectSeparatings {
    public int getPerfectSeparatings(String input){
        int total = 0;
        int inputSize = input.length();
        if(inputSize%2 != 0){
            return total;
        }

        int aCount = 0;
        int bCount = 0;

        //calculate counts
        for(char ch: input.toCharArray()){
            if(ch=='a'){
                aCount++;
            }else{
                bCount++;
            }
        }

        if(aCount%2 != 0 || bCount%2 != 0){
            return 0;
        }

        //calculate combinations

        int aCountHalf = aCount/2;
        int bCountHalf = bCount/2;
        int sizeHalf = inputSize/2;

        if(aCount > 0 && bCount > 0){
            total = calculateCombinations(aCount,aCountHalf)*calculateCombinations(bCount,bCountHalf);
        }else if(aCount > 0){
            //System.out.println("just in aCounts"+aCount+" sizeHalf="+sizeHalf);
            total = calculateCombinations(aCount,sizeHalf);
            //System.out.println("all a's value="+total);
        }else{
            total = calculateCombinations(bCount,sizeHalf);
        }

        return total;
    }

    private int calculateCombinations(int n, int r){
        //System.out.println("n="+n+" and r="+r);
        int nProd = 1;
        int rProd = 1;
        for(int i=1; i<=r; i++){
            nProd *= n--;
        }
        for(int i=1; i<=r; i++){
            rProd *= i;
        }
        //System.out.println("nProd="+nProd+" and rPRod="+rProd);
        return nProd/rProd;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        PerfectSeparatings sol = new PerfectSeparatings();
        String input = sc.nextLine();
        int totalPerfectSeparatings = sol.getPerfectSeparatings(input);
        System.out.println(totalPerfectSeparatings);
    }

}
