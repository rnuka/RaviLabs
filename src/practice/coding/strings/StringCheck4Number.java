package practice.coding.strings;

public class StringCheck4Number {
    public StringCheck4Number() {
    }

    public static void main(String args[]){
        String str = "123.c45";
        int dotCount=0;
        int symbolPosition=1;
        int currPosition=1;

        boolean nonNumberflag=false;
        char[] chr = str.toCharArray();
        //check for multiple dots
        for (char ch: chr){
            if(ch =='.'){
               dotCount++;
            }
            
            if(ch=='-'){
                symbolPosition=currPosition;
            }
            currPosition++;
            
            switch(ch){
                case '1': break;
                case '2': break;
                case '3': break;
                case '4': break;
                case '5': break;
                case '6': break;
                case '7': break;
                case '8': break;
                case '9': break;
                case '0': break;
                case '.': break;
                case '-': break;
                default : nonNumberflag = true;
            }
            
        }
        
        if(nonNumberflag || (symbolPosition>1)||(dotCount>1)){
            System.out.println("not a number");
        }else{
            System.out.println("it is a number");
        }
    }
}
