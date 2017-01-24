package practice.coding.strings;

public class SimplePalindrome {
    public SimplePalindrome() {
    }
    
    public static void main(String args[]){
        String str="lirilt";
        char[] strArray = str.toCharArray();
        boolean isPalindrome = true;
        for(int i=0;i<strArray.length/2;i++){
            if(strArray[i]!=strArray[(strArray.length-1)-i]){
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println("Yes, it is a palindrome");
        }else{
            System.out.println("Oops, it is not a palindrome");
        }
        
    }
}
