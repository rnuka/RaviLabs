package practice.coding.dynamicProgramming;

import java.util.Arrays;

/*
Question: Given two arrays of integers of size m and n where m > n. We need to maximize the dot product by
inserting zeros in the second array but we cannot disturb the order of elements.

Example-1:
----------
Input : A[] = {2, 3 , 1, 7, 8}
        B[] = {3, 6, 7}
Output : 107
Explanation : We get maximum dot product after
inserting 0 at first and third positions in
second array.
Maximum Dot Product : = A[i] * B[j]
2*0 + 3*3 + 1*0 + 7*6 + 8*7 = 107


Example-2:
---------
Input : A[] = {1, 2, 3, 6, 1, 4}
        B[] = {4, 5, 1}
Output : 46

Link: http://www.geeksforgeeks.org/find-maximum-dot-product-two-arrays-insertion-0s/

************************************************************

Sub-problem::
-------------
max_product(a,b,m,n) = max{ max_product(a,b,m-1,n-1)+(m*n),
                              max_product(a,b,m-1,n)
                             }
                     = m*n when n=1
************************************************************

 */
public class MaximumDotProductOf2ArraysWith0Insertions {

    public int maxDotProduct(int[] a, int [] b){
        return maxDotProduct(a,b,a.length-1, b.length-1);
    }

    public int maxDotProduct(int[] a, int[] b, int m, int n){

        if(m<0 || n<0){
            return 0;
        }

        int maxProduct;

        if(m==0 && n==0){
             maxProduct = a[m]*b[n];
        }else{
             maxProduct = Math.max(maxDotProduct(a,b,m-1,n-1)+a[m]*b[n],
                            maxDotProduct(a,b,m-1,n));
        }

        return maxProduct;

    }

    void testcase1(int[] a , int[] b){
        System.out.println("maximum dot product of:: "+ Arrays.toString(a)+ " and "+Arrays.toString(b)
                +" is::"+ maxDotProduct(a,b));
    }

    void testbed(){
        testcase1(new int[]{2, 3 , 1, 7, 8}, new int[]{3, 6, 7});
        //testcase1(new int[]{1, 2, 3, 6, 1, 4}, new int[]{4, 5, 1});
    }

    public static void main(String args[]){
        MaximumDotProductOf2ArraysWith0Insertions m = new MaximumDotProductOf2ArraysWith0Insertions();
        m.testbed();
    }


}
