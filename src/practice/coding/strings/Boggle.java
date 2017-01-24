package practice.coding.strings;

import java.util.Arrays;

public class Boggle {
    public Boggle() {
    }
    
    static char[][] currentBoard ={{'a','b','c','d'},
                              {'n','t','i','p'},
                              {'k','n','g','e'},
                              {'o','s','u','a'}
                              };
    boolean[][] flagBoard = {{false,false,false,false},
                             {false,false,false,false},
                             {false,false,false,false},
                             {false,false,false,false}
                            };
    
    char[] currentStack = {};
    String[] foundWords ={};
    String[] dictionary = {"ant","tank","pig","gun","tic","bank","pea,","pit","azure","dazzle","akn"};
    public void boggleWords(){
        for(int i=0;i<currentBoard.length;i++){
           for(int j=0;j<currentBoard[i].length;j++){
                
                //create memory and push element
                currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                currentStack[currentStack.length-1]=currentBoard[i][j]; 
                
                //mark visited
                flagBoard[i][j]=true;
                
                //call dfs to identify all possible strings with current root element
                dfs(i,j,currentStack, -1, -1);
                
           }
        }
    }
    
    public void dfs(int i, int j, char[] currStack, int lastPopi, int lastPopj){
    

        int currI = i;
        int currJ = j;
        
        while(currStack.length > 0){
            //possible neighbors
            //char currNode = '';
            i = currI;
            j = currJ;
            
            if((i-1)>=0 && i<currentBoard.length && (j-1)>=0 && j<currentBoard[i].length && flagBoard[i-1][j-1]==false){
               //push 
                System.out.println("push :["+(i-1)+"]["+(j-1)+"]");
                currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                currentStack[currentStack.length-1]=currentBoard[i-1][j-1];
                currI = i-1;
                currJ = j-1;
                flagBoard[i-1][j-1]=true;
                //updateLastNodeFlag(lastPopi, lastPopj);
                
            }else if((i-1)>=0 && i<currentBoard.length && (j)>=0 
                && j<currentBoard[i].length && flagBoard[i-1][j]==false){
                //push 
                 System.out.println("push :["+(i-1)+"]["+(j)+"]");
                 currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                 currentStack[currentStack.length-1]=currentBoard[i-1][j];
                currI = i-1;
                currJ = j;
                flagBoard[i-1][j]=true;
                //updateLastNodeFlag(lastPopi, lastPopj);
            }else if((i-1)>=0 && i<currentBoard.length && (j+1)>=0 && (j+1)<currentBoard[i].length 
                              && flagBoard[i-1][j+1]==false){
                //push 
                 System.out.println("push :["+(i-1)+"]["+(j+1)+"]");
                 currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                 currentStack[currentStack.length-1]=currentBoard[i-1][j+1];
                currI = i-1;
                currJ = j+1;
                flagBoard[i-1][j+1]=true;
                //updateLastNodeFlag(lastPopi, lastPopj);
            }else if((i)>=0 && i<currentBoard.length && (j-1)>=0 && j<currentBoard[i].length && flagBoard[i][j-1]==false){
                //push 
                 System.out.println("push :["+(i)+"]["+(j-1)+"]");
                 currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                 currentStack[currentStack.length-1]=currentBoard[i][j-1];
                currI = i;
                currJ = j-1;
                flagBoard[i][j-1]=true;
                //updateLastNodeFlag(lastPopi, lastPopj);
            }else if(i>=0 
                     && i<currentBoard.length 
                     && (j+1)>=0 && (j+1)<currentBoard[i].length 
                     && flagBoard[i][j+1]==false
                     ){
                //push 
                 System.out.println("push :["+(i)+"]["+(j+1)+"]");
                 currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                 currentStack[currentStack.length-1]=currentBoard[i][j+1];
                currI = i;
                currJ = j+1;
                flagBoard[i][j+1]=true;
                //updateLastNodeFlag(lastPopi, lastPopj);
                
            }else if((i+1)>=0 && (i+1)<currentBoard.length && (j-1)>=0 && j<currentBoard[i].length 
            && flagBoard[i+1][j-1]==false){
                //push 
                 System.out.println("push :["+(i+1)+"]["+(j-1)+"]");
                 currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                 currentStack[currentStack.length-1]=currentBoard[i+1][j-1];
                currI = i+1;
                currJ = j-1;
                flagBoard[i+1][j-1]=true;
                //updateLastNodeFlag(lastPopi, lastPopj);
            }else if((i+1)>=0 
            && (i+1)<currentBoard.length 
            && (j)>=0 && 
            j<currentBoard[i].length 
            && flagBoard[i+1][j]==false){
                //push 
                 System.out.println("push :["+(i+1)+"]["+(j)+"]");
                 currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                 currentStack[currentStack.length-1]=currentBoard[i+1][j];
                currI = i+1;
                currJ = j;
                flagBoard[i+1][j]=true;
                //updateLastNodeFlag(lastPopi, lastPopj);
            }else if((i+1)>=0 && (i+1)<currentBoard.length && (j+1)>=0 && j<currentBoard[i].length && flagBoard[i+1][j+1]==false){
                //push 
                 System.out.println("push :["+(i+1)+"]["+(j+1)+"]");
                 currentStack = Arrays.copyOf(currentStack, currentStack.length+1);
                 currentStack[currentStack.length-1]=currentBoard[i+1][j+1];
                currI = i+1;
                currJ = j+1;
                flagBoard[i+1][j+1]=true;
                //updateLastNodeFlag(lastPopi, lastPopj);
            }else{
                
                
                
                //if all neighbours are visited and no further unvisited nodes
                //check from dictionary if the word is present 
                //if present add to words array and pop
                String currStr = new String(currentStack);
                System.out.println("currStr="+currStr);
                findWord(currStr);
                
                //if any previous popped nodes available then make them available
                updateLastNodeFlag(lastPopi, lastPopj);
                
                
                //Pop the last character
                System.out.println("current stack length="+currentStack.length);
                if(currentStack.length>0){
                currentStack = Arrays.copyOf(currentStack, currentStack.length-1);
                
                    lastPopi = currI;
                    lastPopj = currJ;
                
                //recurse dfs call to start search with current string 
                //  and do not mark visited to false immediately
                dfs(currI,currJ,currentStack,currI,currJ);
                }else{
                    break;
                }
                
            }
               
        }
        
    }
    
    public void findWord(String currWord){
        String currString = new String(currentStack);
        for(int k=0;k<dictionary.length;k++){
            if(currString.equals(dictionary[k])){
                //add to words found
                 foundWords= Arrays.copyOf(foundWords, foundWords.length+1);
                 foundWords[foundWords.length-1]= dictionary[k];
            }
            
        }
    }
    
    public void updateLastNodeFlag(int i, int j){
        //if lastpopi, lastpopj are not null then release the node for next combination
        if(i != -1 && j != -1){
            System.out.println("updating i="+i+" and j="+j+"position to false ");
            flagBoard[i][j]=false;
        }
    }
    
    public static void main(String args[]){
    
        Boggle bg = new Boggle();
        bg.boggleWords();
        for(int i=0;i<bg.foundWords.length;i++){
            System.out.println(bg.foundWords[i]);
        }
        
    }
}
