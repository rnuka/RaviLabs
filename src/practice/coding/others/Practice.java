package practice.coding.others;

/**
 * Created by rnuka on 12/12/15.
 */
public class Practice {
    //longest palindrome
    String longestPalindrome(String s){
        StringBuilder longestPalindrome= new StringBuilder();
        StringBuilder batchString = new StringBuilder(s);
        for(int i=0;i < batchString.length(); i++){
            batchString = new StringBuilder(s.substring(i,s.length()));
            System.out.println("batchString="+batchString);
            StringBuilder innerString = new StringBuilder(batchString);
            for(int j=0; j < innerString.length(); j++){
                innerString = new StringBuilder(batchString.substring(0,batchString.length()-j));
                System.out.println("innerString="+innerString);
                StringBuilder checkString = new StringBuilder(innerString);
                char flag = 'Y' ;
                for(int k=0; k<checkString.length(); k++){
                    if(checkString.charAt(k) != checkString.charAt(checkString.length()-k-1)){
                        flag='N';
                        break;
                    }
                }
                if(flag == 'Y' && longestPalindrome.length() < checkString.length()){
                    longestPalindrome = checkString;
                }
            }

        }
        return longestPalindrome.toString();
    }

    public static void main(String args[]){
        Practice p = new Practice();
        System.out.println("longest Palindrome is ::" + p.longestPalindrome("tatoo"));
    }
}
