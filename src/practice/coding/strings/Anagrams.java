package practice.coding.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public Anagrams() {
    }
    public static void main(String args[]){
        Anagrams ang = new Anagrams();
        String[] str = {"dog","god","cat","act","xyz"};
        List<String> tempList;
        Map<String,List> mp = new HashMap<String,List>();
        
        for(int i=0;i<str.length;i++){
            //sort the string
            String temp=ang.sort(str[i]);
            //store in the map
            if(mp.get(temp) != null){
                tempList = (ArrayList)mp.get(temp);
                tempList.add(str[i]);
                mp.put(temp,tempList);
            }else{
                tempList = new ArrayList<String>();
                tempList.add(str[i]);
                mp.put(temp,tempList);
            }
            tempList=null;
        }
        
        //loop through map and print all elements whose count of list > 1
        for(Map.Entry<String,List> entry:mp.entrySet()){
            tempList = entry.getValue();
            if(tempList.size()>1){
                    System.out.println("----Anagram----");
                    for(int i = 0; i < tempList.size(); i++) {
                                System.out.println(tempList.get(i));
                            }
            }
        }
    }
    
    public String sort(String str){
        String temp;
        char[] tempc=str.toCharArray();
        Arrays.sort(tempc);
        temp=new String(tempc);
        return temp;
    }
}
