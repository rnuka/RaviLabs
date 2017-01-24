package practice.coding.recursion;

/**
 * Created by rnuka on 5/4/16.
 */
/*
* Input: Given two strings
* Output: longest common substring of two strings
* Approach: We can follow dynamic programming approach to construct a (M+1)(N+1) table with first row as String1
* and first column and String2 and then populate the matching values and return the longest diagonal from the matrix
* M is length of String2 (rows) and N is length of String1 (columns)
* */
public class LongestCommonSubstring {
    public static String largestCommonSubString(String first, String second){
        int[][] results = new int[first.length()+1][second.length()+1];

        //populate rest of the matrix with matches
        int largest_x = 1;
        int largest_diag = 1;
        for(int i=0; i<first.length(); i++){
            for(int j=0; j<second.length(); j++){
                //if matches
                if(first.charAt(i) == second.charAt(j)){
                    System.out.println("match found at i="+i+ " and j="+j);
                    //look for previous element on diagonal and increment accordingly.
                    if(i>0 && j>0){
                        results[i][j] = results[i-1][j-1]+1;

                    }else{
                        results[i][j] = 1;
                    }
                    //check if better match found
                    if(results[i][j]>largest_diag){
                        largest_diag=results[i][j];
                        largest_x = i;
                    }
                }else{
                    results[i][j] = 0;
                }
            }
        }

        System.out.println("largest_diag="+largest_diag+" and largest_x="+largest_x);

        //form the largest common string based on diagonal
        String returnVal = "";
        for(int i=0; i<largest_diag; i++){
            returnVal = returnVal + first.charAt(largest_x-largest_diag+1+i);
        }

        return returnVal;
    }

    public static void main(String args[]){
        System.out.println("val="+largestCommonSubString("apple","zappxplye"));
    }
}
