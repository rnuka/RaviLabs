package practice.coding.recursion;

/*
Approach:
reverse(n) = n+reverse(n-1) when n > 1
           = charAt(n) when n = 1;
     n = length of input

 */
public class StringReverseRecursive {
    public StringReverseRecursive() {
    }
    
    public StringBuilder reverseString(String str){

        int n = str.length();

        if(n <= 1){
          return new StringBuilder(str);
        }

        StringBuilder revStr = new StringBuilder("");


        revStr = revStr.append(
                        str.charAt(n - 1)).append(
                reverseString(str.substring(0, n - 1))
        );
        return revStr;

    }

    public static void main(String args[]){
        String str = "testing";
        StringReverseRecursive sr = new StringReverseRecursive();
        System.out.println("reverse string="+ sr.reverseString(str));


    }
}
