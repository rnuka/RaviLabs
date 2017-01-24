package practice.coding.games;

import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public HangMan() {
    }
    
    public static String[] sentenceDictionary = {
        "I am the boss, do you know",
        "Why did Katappa killed Bahubali",
        "If you're happy and you know it, clap your hands",
        "APJ Abdul Kalam is thirteenth president of India"
    };
    
    static int mistakeCount=0;
    private static Scanner scanner;
    static boolean userWon = false;
    
    static public void checkNFill(String randString, char[] emptyString, char alpha){
        boolean match = false;
        char[] stringArray = randString.toCharArray();
        for(int i=0;i<stringArray.length;i++){
            if(Character.toUpperCase(stringArray[i])== Character.toUpperCase(alpha) ){
                emptyString[i]=stringArray[i];
                match=true;
            }
        }
        
        if(match==false){
            mistakeCount++;
            System.out.println("No matches");
        }
        
        //print after filling
         for(int i=0;i<emptyString.length;i++){
             System.out.print(" "+emptyString[i]);
         }
         
        //check if user won
        if(String.valueOf(emptyString).contains("_")){
            userWon=false;
        }else{
            userWon=true;
        }
        
        
    }
    
    
    public static void main(String args[]){
        
        //form a random sentence from dictionary
        Random randomGen = new Random();
        int i =randomGen.nextInt(3);
        
        String randString = sentenceDictionary[i];
        System.out.println("randString="+randString);
        
        char[] emptyString = new char[randString.length()];
        System.out.println("emptryString length="+emptyString.length);
        
        for(int j=0;j<emptyString.length;j++){
            emptyString[j]='_';
            System.out.print(" "+emptyString[j]);
        }
        
        System.out.println("");
        
        
        Scanner scanner = new Scanner(System.in);
        
        while(mistakeCount<6 && userWon==false){
        
        System.out.println("enter character you predicted");
        Character userFeedChar = scanner.nextLine().toCharArray()[0];
        checkNFill(randString, emptyString, userFeedChar);
        
        }
        
        if(userWon==true){
            System.out.println("Congratulations, you won");
        }else{
            System.out.println("Better luck next time");
        }
        
        
        
        
    }
    
}
