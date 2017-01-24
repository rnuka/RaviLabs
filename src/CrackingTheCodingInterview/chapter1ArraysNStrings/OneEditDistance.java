package CrackingTheCodingInterview.chapter1ArraysNStrings;

/*
Given two strings S and T, determine if they are both one edit distance apart.

edit means -> it can be insert or update or remove
 */
public class OneEditDistance {

    public boolean isOneEditDistance(String s1, String s2){
        if(s1.equalsIgnoreCase(s2)){ //same strings
            return false;
        }
        if(s1.length() == s2.length()){
            return isOneEditReplaceAway(s1,s2);
        }else if(s1.length() == s2.length()+1){ //s1 is one char longer than s2
            return isOneEditInsertAway(s2,s1); //i.e. insert into s2
        }else if(s2.length() == s1.length()+1) { //s2 is one char longer than s2
            return isOneEditInsertAway(s1,s2);
        }
        return false;
    }

    private boolean isOneEditReplaceAway(String s1, String s2){
        boolean foundDifference = false;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    private boolean isOneEditInsertAway(String s1, String s2){
        int j=0; //index to track s1
        boolean foundDifference = false;
        for(int i=0; i<s2.length() && j<s1.length(); i++){
            if(s1.charAt(j)!=s2.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }else{
                j++;
            }
        }
        return true;
    }

    public void testcase2(){
        String s1="abc";
        String s2="ac";
        System.out.println("s1, s2 : is edit distance 1? :: "+isOneEditDistance(s1,s2));
    }

    public void testcase1(){
        String s1="abc";
        String s2="ab";
        System.out.println("s1, s2 : is edit distance 1? :: "+isOneEditDistance(s1,s2));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        OneEditDistance o = new OneEditDistance();
        o.testbed();
    }

}
