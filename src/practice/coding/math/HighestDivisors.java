package practice.coding.math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HighestDivisors {
    public HighestDivisors() {
    }
    public static Map<Integer,String> hm = new HashMap<Integer,String>();
    int counter = 0;
    String divisorString = "";
    int highestDivisors = 0;
    int highestDivNum = 1;
    String highestDivString ="";
    public void populateDivisors(int num){
        for (int i=1;i<=num;i++){
            counter=0;
            divisorString="";
            for(int j=1;j<=i;j++){
                if(i%j ==0){
                   counter++;
                   divisorString=divisorString+","+j;
                }
            }
            if(counter>highestDivisors){
                highestDivisors=counter;
                highestDivNum=i;
                highestDivString = divisorString;
            }
            divisorString=counter+"::"+divisorString;
            //System.out.println("i="+i+" divisorString="+divisorString);
            hm.put(i,divisorString);
        }
        System.out.println("test"+hm.get(1));
        Iterator it = hm.entrySet().iterator();
        String str = "";
        System.out.println("highest divisors="+highestDivisors);
            while (it.hasNext()) {
               
                Map.Entry pair = (Map.Entry)it.next();
                str = pair.getValue().toString();
                String temp = str.substring(0,str.indexOf("::"));
                //System.out.println("temp="+temp);
                
                if(temp.equalsIgnoreCase(String.valueOf(highestDivisors))){
                    System.out.println(pair.getKey()+"-"+str);
                }
                it.remove(); // avoids a ConcurrentModificationException
            }
        
    }

    public static void main (String args[]){
         HighestDivisors h = new HighestDivisors();
         h.populateDivisors(100);


    }
    
}
