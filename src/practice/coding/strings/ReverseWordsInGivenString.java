package practice.coding.strings;

/*
Question: Reverse words in a given string

Constraints: 1. It should be O(N) time and O(1) space.
             2. split() function and pushing on / popping off the stack are not allowed

Example:
input: “i like this program very much”.
output: “much very program this like i”
 */
public class ReverseWordsInGivenString {


    //Below method does in O(n) but uses split function.
    public String reverseWords(String input){
        String str[] = input.split(" ");
        String finalStr="";
        for(int i = str.length-1; i>= 0 ;i--){
            finalStr += str[i]+" ";
        }
        return finalStr;
    }

    //Correct Solution:
    /*
    Logic:  start from end, traverse until a space is met then take substring from space+1 to last and built a resultant.
     */
    public static String reverseWords2(String string) {
        if (string.isEmpty()) {
            return string;
        }
        int last = string.length();
        StringBuilder sb = new StringBuilder(string.length());
        /*boolean contextspace = ' ' == string.charAt(string.length() - 1);
        for (int i = string.length() - 1; i >= 0; i--) {
            if (contextspace != (string.charAt(i) == ' ')) {
                sb.append(string.substring(i + 1, last));
                last = i + 1;
                contextspace = !contextspace;
            }
        }*/

        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) == ' ') {
                sb.append(string.substring(i+1,last)).append(" ");
                last = i;
            }
        }


        sb.append(string.substring(0, last));
        return sb.toString();
    }

    public static void main(String args[]){
        String input = "test cat hit waste";
        System.out.println(" revese of "+input+" is::"+reverseWords2(input));
    }
}
