package CrackingTheCodingInterview.chapter1ArraysNStrings;

/*
Write a function that takes an integer and prints out the English text of it.
Example: Input: 1432
        Output: 'One thousand, four hundred thirty-two'
* */
public class EnglishNumber {


    String[] units = {"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine ","ten ","eleven ","twelve ",
                        "thirteen ", "fouteen ","fifteen ","sixteen ","seventeen ","eighteen ","nineteen "};
    String[] tens = {"","","twenty ","thirty ","fourty ","fifty ","sixty ","seventy ","eighty ","ninety "};
    String hundred = "hundred and ";
    String bigs[] = {"","thousand ","million ","billion ","trillion "};


    //Convert number to words
    public String numberToEnglish(int number){

        StringBuilder output = new StringBuilder("");

        if(number<=0){
            return "zero";
        }

        int bigsCounter=0;
        while(number>0){
            //extract last 3 digits
            int last3Digits = number%1000;
            output.insert(0, (convert3Digits(last3Digits).append(bigs[bigsCounter])));

            number = number/1000;
            bigsCounter++;
        }

        return output.toString();
    }
    private StringBuilder convert3Digits(int n){

        StringBuilder result = new StringBuilder("");

        if(n>99){
            result= result.append(units[n/100]).append(hundred);
            n=n%100;
        }

        if(n>19){
            result=result.append(tens[n/10]);
            n=n%10;

        }

        if(n>0){
            result=result.append(units[n]);
        }


        return result;
    }

    public void testcase2(){
        int num = 1234519;
        System.out.println(numberToEnglish(num));
    }

    public void testcase1(){
        int num = 1234;
        System.out.println(numberToEnglish(num));
    }
    public void testbed(){
        testcase1();
        testcase2();
    }

    public static void main(String[] args){
        EnglishNumber e = new EnglishNumber();
        e.testbed();
    }
}
