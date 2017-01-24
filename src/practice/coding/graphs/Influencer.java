package practice.coding.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Influencer {
    public Influencer() {
    }
    
    static int[][] adjMatrix = {
                            {0,1,0,0},
                            {0,0,1,0},
                            {0,0,0,1},
                            {0,0,0,0},
                        };
    int root;  
    
    int[] queueArray={};
    int[] cycleChecks={0,0,0,0};
    
                        
    public void bfs(){
        /*
         * check every node for bfs and ensure they all 
         *  have node influencing every other node but no cycles.
         */
        for(int i=0;i<adjMatrix.length;i++){
             System.out.println();
             //Create a set to see if all elements are influenced.
             Set s = new HashSet();
             
             //add the self influencer
             s.add(i);
             
             //reset queue to root element
             queueArray = Arrays.copyOf(queueArray,1);
             queueArray[0]=i;
             
             int counter=0;
             
             //navigate while queue is not empty
             int currNode=0;
             while(queueArray.length >0 ){
             
                
                 
                 //dequeue first element from queue and arrange queue by moving elements
                 currNode = queueArray[0];
                 if(queueArray.length >1){
                     for(int k=0;k<queueArray.length;k++){
                         queueArray[k]=queueArray[k+1];
                         
                     }
                     queueArray = Arrays.copyOf(queueArray,queueArray.length-1);
                 }else{
                     queueArray = Arrays.copyOf(queueArray,0);
                 }
                 
                 
                //look for edges corresponding to dequeued element
                for (int j=0;j<adjMatrix[i].length;j++){
                    if(currNode < adjMatrix.length && adjMatrix[currNode][j]==1 ){
                       //if edge found, enqueue it if not cycle
                        if(adjMatrix[j][i] ==1){
                            cycleChecks[i]=j+1;
                            break; //cycle found
                        }
                        queueArray = Arrays.copyOf(queueArray,queueArray.length+1);
                        queueArray[queueArray.length-1]=j;
                        s.add(j);
                        
                    }
                }
                 
             }
             
             
             //check if set contains all elements 
             if(s.size()== adjMatrix[i].length && cycleChecks[i]==0){
                 System.out.println(i+1+" is an INFLUENCER ::"+s.size());
             }else{
             
                 if(cycleChecks[i]>0){
                     System.out.println(i+1+" is not an influencer because Cycle found from node:"+cycleChecks[i]);
                 }else{
                 System.out.println(i+1+" is NOT influencing all others::"+s.size());
                 }
             }
             
             
         
         }
         
            
        
    }
    public static void main(String args[]){
        Influencer ifs = new Influencer();
        ifs.bfs();
    }
}
