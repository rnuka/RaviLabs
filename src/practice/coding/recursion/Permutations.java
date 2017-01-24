package practice.coding.recursion;
 
/*
 * Psuedocode:
 * 1. Take input string to a method
 * 2. Trim last character and recurse until single character
 * 3. Return once single character appears
 * 4. combine method to form strings based on so far Strings
 * 5. Return final List
*/

public class Permutations {
    


    //Public method
    public static void permutation(String str) {
        permutation("", str);
    }

    //Private method
    private static void permutation(String prefix, String str) {

        //System.out.println("prefix="+prefix+" and str="+str);

        int n = str.length();

        //if whole string is moved to prefix then print it
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
                //Java Learn: In above line str.substring(i+1,n) even though i+1 become n, str.subtring will not throw index out of bound exception because java doc allows substring from o to length (not length-1)
        return;
    }
    
    
    
    public static void main(String args[]){
        StringBuilder inputString = new StringBuilder("YAHOO");
        Permutations perm = new Permutations();

        /*
        //Approach-1
        perm.generatePermutations(inputString);

        // print output
        for(StringBuilder str: outputStrings){
            System.out.println("str="+str);
        }
        */


        /*
        //Approach-2
        List<String> outputStrings = perm.populatePermutations("ABC");
        Set<String> hs = new HashSet<>();
        hs.addAll(outputStrings);
        outputStrings.clear();
        outputStrings.addAll(hs);

        // print output
        for(String str: outputStrings){
            System.out.println("str="+str);
        }
        */

        //Approach-3
        permutation(inputString.toString());




    }
}
