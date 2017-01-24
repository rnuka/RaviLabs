package practice.coding.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rnuka on 12/15/15.
 */
public class Practice4 {

        public static void main(String args[]){
            InputStreamReader isr = null;
            BufferedReader br = null;
            try{
                isr = new InputStreamReader(System.in);
//              System.out.println("Write data: ");
//              int i = isr.read();
//              System.out.println("Data read is: " + i);
                //Thus the InputStreamReader is useful for reading the character from the stream
                System.out.println("Enter the data to be read by the bufferedReader: ");
                //here isr is containing the lnefeed already so this is needed to be flushed.
                br = new BufferedReader(isr, 2);
                String str = br.readLine();
                System.out.println("The data is : :" +  str);
            }catch(IOException e){
                System.out.println("Can't read: " + e.getMessage());
            }
        }

}
