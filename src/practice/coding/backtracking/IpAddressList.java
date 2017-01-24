package practice.coding.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnuka on 11/11/16.
 */
/*
* Question:

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:

input: "25525511135",

output:  ["255.255.11.135", "255.255.111.35"]

{hint:recursion,backtrack}

* */
public class IpAddressList {
    public List<String> ipAddressList(String input){
        List<String> results = new ArrayList<String>();

        //invalid input
        int inputLength = input.length();
        if(inputLength < 4 || inputLength > 12){
            return results;
        }

        ipAddressList(input,1,results,"");
        return results;
    }

    private void ipAddressList(String currentInput, int octant, List results, String currentBuffer){


        //base case
        if(octant == 4 && Integer.parseInt(currentInput) <= 255){
            results.add(currentBuffer+currentInput); //to remove . at end
            return;
        }

        //other cases
        for(int i=0; i< 3; i++){
            String temp = currentInput.substring(0,i+1);

            //validate if currentBuffer is valid i.e. 0-255
            if(Integer.parseInt(temp) <= 255){
                String remainingStr = currentInput.substring(i+1);
                if (remainingStr.length() >= (4 - octant)
                        && remainingStr.length() <= (4-octant)*3) {
                    ipAddressList(remainingStr, octant + 1, results, currentBuffer+temp + ".");
                }
            }
        }
        return;
    }

    public void testcase1(){
        String input = "25525511135";
        List<String> results = ipAddressList(input);
        for(String s : results){
            System.out.println("******IpAddress: "+s);
        }
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        IpAddressList ip = new IpAddressList();
        ip.testbed();
    }
}
