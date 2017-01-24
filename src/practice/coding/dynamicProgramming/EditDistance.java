package practice.coding.dynamicProgramming;

/*

Given two strings str1 and str2 and below operations that can performed on str1. Find minimum
number of edits (operations) required to convert ‘str1’ into ‘str2’.

Operations Allowed:
Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations.
Replace 'n' with 'r', insert t, insert a
* */

/*
* Algorithm : f(m,n) where m is index in first string and n is index in second string then
* if character at m index of s1 and character n index of s2 are same.
*   minEdit(m,n) = minEdit(m-1,n-1)
* else
*   minEdit(m,n) = 1+min(
*                      minEdit(m,n-1) //insert,
*                      minEdit(m-1,n-1) //update,
*                      minEdit(m-1,n) //remove
*                      )
* */
public class EditDistance {

    public int minEdit(String s1, String s2){
        return minEditRecursive(s1,s2,s1.length()-1,s2.length()-1);
    }

    // m is s1 index reference and n is s2 index reference
    private int minEditRecursive(String s1, String s2, int m, int n){
        if(m<0){
            return n;
        }
        if(n<0){
            return m;
        }
        //if char at m of s1 matches chat at n of s2, then solve m-1,n-1 strings
        if(s1.charAt(m)==s2.charAt(n)){
            return minEditRecursive(s1,s2,m-1,n-1);
        }else{
            //Note: Math.max is important so that negative results are ignored.
            return 1+Math.max(0,Math.min((Math.min(minEditRecursive(s1,s2,m,n-1), //insert
                                        minEditRecursive(s1,s2,m-1,n-1))), //update
                              minEditRecursive(s1,s2,m-1,n) //remove
                              ));
        }
    }

    public int minEditDp(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<=s1.length(); i++){
            for(int j=0; j<=s2.length();j++){
                if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(Math.min(dp[i][j-1], //insert
                                    dp[i-1][j-1]), //update
                            dp[i-1][j]); //remove

                }

            }
        }
        return dp[s1.length()][s2.length()];
    }


    public void testcase2(){
        int minEdit = minEditDp("abc", "xyz");
        System.out.println("min edit between abc and xyz ::"+minEdit);
        //myAssert(minEdit==3);

    }

    public void testcase1(){
        int minEdit = minEdit("abc", "xyz");
        System.out.println("min edit between abc and xyz ::"+minEdit);
        myAssert(minEdit==3);

    }


    public void testbed(){
        testcase1();
         //testcase2();
    }

    public static void main(String args[]){
        EditDistance ed = new EditDistance();
        ed.testbed();
    }

    private void myAssert(boolean x){
        if(!x){
            throw new IllegalArgumentException("Assert Fails");
        }
    }
}
