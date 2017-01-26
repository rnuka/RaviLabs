package practice.coding.strings;

public class StringReverse {
    String reverse="";
    public StringReverse() {
    }


    //Use string builder
    public String reverse(String str){
        reverse = reverse+Character.toString(str.charAt(str.length()-1));
        String remainder = str.substring(0,str.length()-1);
        if(remainder.length()>0){
            reverse += reverse(remainder);
        }
        return reverse;
    }
}
