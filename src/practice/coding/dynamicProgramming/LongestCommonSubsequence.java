package practice.coding.dynamicProgramming;
/*
* LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
* A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
* For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
* So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the
differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

* */

/*
* Optimal substructure: Let m, n be indexes on strings s1, s2 then
* if(char at m is same as char at n) then
* f(m,n) = 1+f(m-1,n-1)
* otherwise
* f(m,n)= max(f(m,n-1), f(m-1,n))
*
* basecase:
* if(m==0 or n==0) then 0
*
* */
public class LongestCommonSubsequence {

    public int longestCommonSubseq(String s1, String s2){
        return longestCommonSubseq(s1,s2,s1.length()-1,s2.length()-1);
    }

    //using recursion and without dp
    private  int longestCommonSubseq(String s1, String s2, int m, int n){
        if(m<0 || n<0){
            return 0;
        }else if(s1.charAt(m)==s2.charAt(n)){
            return 1+longestCommonSubseq(s1,s2,m-1,n-1);
        }else{
            return Math.max(longestCommonSubseq(s1,s2,m,n-1),longestCommonSubseq(s1,s2,m-1,n));
        }
    }

    //using dp
    private  int longestCommonSubseqDp(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];
        String output = "";
        for(int i=1; i<=s1.length();i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+(dp[i-1][j-1]);
                    if(dp[i][j]>dp[i-1][j] || dp[i][j]>dp[i][j-1] ) {
                        output += s1.charAt(i - 1);
                    }
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println("longest common subsequence="+output);

        return dp[m][n];
    }

    //TODO: print longest common subsequence string.

    public void testcase2(){
        String s1="AGGTAB";
        String s2="GXTXAYB";
        System.out.println("longest common subsequence for"+s1+"  and "+s2+" is:"+longestCommonSubseq(s1,s2));
        System.out.println("longest common subsequence dp appraoch " +
                "for"+s1+"  and "+s2+" is:"+longestCommonSubseqDp(s1, s2, s1.length(), s2.length()));
    }

    public void testcase1(){
        String s1="ABCDGH";
        String s2="AEDFHR";
        System.out.println("longest common subsequence for"+s1+"  and "+s2+" is:"+longestCommonSubseq(s1,s2));
        System.out.println("longest common subsequence dp appraoch " +
                "for"+s1+"  and "+s2+" is:"+longestCommonSubseqDp(s1, s2, s1.length(), s2.length()));
    }

    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        lcs.testbed();
    }
}
