import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class HelloWorld{

    public static void main(String[] args){

       double a = 1;
       double b = 2;
        a++;
        b++;
        DecimalFormat d = new DecimalFormat("#.00");
        //double c = d.format(a / b);

        System.out.println(d.format(a/b));


    }

}