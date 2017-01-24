package practice.coding.dynamicProgramming;

/*
Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds
if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).

The wildcard pattern can include the characters ‘?’ and ‘*’
‘?’ – matches any single character
‘*’ – Matches any sequence of characters (including the empty sequence)

For example,

Input Text = "baaabab",
Input Pattern = “*****ba*****ab", output : true
Input Pattern = "baaa?ab", output : true
Input Pattern = "ba*a?", output : true
Input Pattern = "a*ab", output : false
 */

/*
Approach:
match(s,p,i,j) = true when match(s,p,i-1,j-1) is true and p(j)='?' or p(j)=s(i)
               = true when p(j)='*' & match(s,p,i-1,j) or match(s,p,i,j-1) is true.
                                i.e. consider * as empty or use it for char replacement.
               = false otherwise
 */
public class RegularExpressionMatching {

    //using recursion (Lot of repetitive recursions, hence not optimal solution)
    public boolean isMatch(String s, String p, int i, int j){

        //empty string and empty pattern
        if(i<0 && j<0){
            return true;
        }

        //one pattern is empty
        if(j<0){
            return false;
        }

        //Other cases
        if(p.charAt(j)=='*'){
            return isMatch(s,p,i,j-1)||isMatch(s,p,i-1,j);
        }else if(p.charAt(j)=='?' || p.charAt(j)==s.charAt(i)){
            return isMatch(s,p,i-1,j-1);
        }else{
            return false;
        }
    }

    //using dp approach
    public boolean isMatchDp(String s, String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        //basecase: empty string and empty pattern
        dp[0][0] = true;

        //populate empty string vs possible patterns (i.e. if pattern is non empty then it is false)
        for(int k=1; k<p.length(); k++){
            //only * can be matched with empty string
            if(p.charAt(k-1)=='*'){
                dp[0][k]=dp[0][k-1];
            }
        }

        //populate rest of the dp for non empty input string
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length(); j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]= (dp[i][j-1]||dp[i-1][j]);
                }else if(p.charAt(j-1)=='?' ||
                        p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[s.length()][p.length()];

    }

    public void testcase3(){
        System.out.println("****** TESTCASE-3 (Using DP) **********");
        String input="ab";
        String pattern = "a*";
        System.out.println("pattern:"+pattern+"  matches with input:"+input+" ::"
                +isMatchDp(input,pattern));

    }

    public void testcase2(){
        System.out.println("****** TESTCASE-2 **********");
        String input="baaabab";
        String pattern = "*****ba*****ab";
        System.out.println("pattern:"+pattern+"  matches with input:"+input+" ::"
                +isMatch(input,pattern,input.length()-1,pattern.length()-1));

    }

    public void testcase1(){
        System.out.println("****** TESTCASE-1 **********");
        String input="ab";
        String pattern = "a*";
        System.out.println("pattern:"+pattern+"  matches with input:"+input+" ::"
                +isMatch(input,pattern,input.length()-1,pattern.length()-1));

    }

    public void testbed(){
        testcase1();
        testcase2();
        testcase3();
    }


    public static void main(String args[]){
        RegularExpressionMatching rg = new RegularExpressionMatching();
        rg.testbed();
    }
}
