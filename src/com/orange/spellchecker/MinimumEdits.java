package com.orange.spellchecker;

/**
 * Created by rnuka on 10/26/15.
 */
public class MinimumEdits {

    char[] sArray;
    char[] tArray;
    int[][] distance;

    public MinimumEdits(String s, String t){
        distance = new int[s.length()+1][t.length()+1];
        sArray = s.toCharArray();
        tArray = t.toCharArray();
    }

    public int minimumEdit(String s, String t){

        //System.out.println("s="+s+" and t="+t);

        //initialize first column
        for(int i=0; i<= s.length(); i++){
            distance[i][0]=i;
        }

        //initialize first row
        for(int i=0; i<= t.length(); i++){
            distance[0][i]=i;
        }


        //loop source string
        for(int i=0; i < sArray.length; i++) {

            //loop destination string
            for (int j = 0; j < tArray.length; j++) {
                int edit = 1;

                if(Character.toUpperCase(sArray[i]) == Character.toUpperCase(tArray[j])) {
                    edit = 0;
                }

                /*System.out.println("i= "+i+" and j="+j+" distance[i][j+1] + 1="+(distance[i][j+1]+1)+
                        " :: distance[i+1][j] + 1)="+(distance[i+1][j] + 1)
                        +" :: distance[i][j]+edit="+(distance[i][j]+edit)
                );
                */

                distance[i+1][j+1] = Math.min(Math.min(distance[i][j+1] + 1, distance[i+1][j] + 1), distance[i][j]+edit);
            }
        }
        return distance[s.length()][t.length()];
    }


}
