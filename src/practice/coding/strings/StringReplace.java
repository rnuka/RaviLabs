package practice.coding.strings;

import java.util.HashMap;
import java.util.Map;

public class StringReplace {
    public StringReplace() {
    }
    
    static boolean openTag = false;
    
    //parser-1:::Assumption: Always open tag starts with space 
    public String replaceTags(String inputString){
        
        //difference between open tag and close tag is open tags start with space+tagname
        //first replace front tags i.e. space+tagname
        inputString = inputString.replace(" $strikethrough$"," <B>");
        System.out.println(inputString);
        
        //replace close tags
        inputString = inputString.replace("$strikethrough$","</B>");
        System.out.println(inputString);
        
        
        //repeat same as above for other tags
         //first replace front tags i.e. space+tagname
         inputString = inputString.replace(" $underline$"," <U>");
         System.out.println(inputString);
         
         //replace close tags
         inputString = inputString.replace("$underline","</U>");
         System.out.println(inputString);
         
        
        return inputString;
    }
    
    
    //parser-2
    public StringBuffer replaceTags2(StringBuffer inputString, String oldTag, String newTag){
        
        int currIndex = inputString.indexOf(oldTag);
        if(currIndex>=0){
            
            if(openTag)
               openTag = false;
            else   
               openTag = true;
               
            replaceTags2(inputString.replace(currIndex,
                                             currIndex+oldTag.length(),
                                             (openTag ? "\r\n "+newTag:newTag.replace("<","</")+"\r\n ")
                                             )
                                             , oldTag, newTag);
        }

           //System.out.println("before exit+"+inputString);
        return inputString;
    }
    
    
    //parser-3
    public StringBuffer replaceTags3(StringBuffer inputString, Map<String,String> tagMap){
        boolean openFlag = false; 
        //Loop through tag
        for(Map.Entry<String,String> entry: tagMap.entrySet()){
            
            //replace each pair of old tag with new tag, key=oldTag and val=newTag
            int currIndex=0;
            String oldTag = entry.getKey();
            String newTag = entry.getValue();
            
            //replace old tag with new tag recursively
            while((currIndex=inputString.indexOf(entry.getKey()))>0){
                
                //flip flag
                if(openTag)
                   openTag = false;
                else   
                   openTag = true;
                
                //replace old tag with new tag
                inputString.replace(currIndex,currIndex+oldTag.length(),
                                    (openTag ? "\r\n "+newTag:newTag.replace("<","</")+"\r\n ")
                                   );
            }
        }

        return inputString;
    }
    
   
    
    public static void main (String args[]){
        StringBuffer inputString = new StringBuffer("choice of$strikethrough$3$strikethrough$2 - 101,$strikethrough$102$strikethrough$,103,$underline$104$underline$,105,$strikethrough$106$strikethrough$");

        StringReplace strReplace = new StringReplace();
        //strReplace.replaceTags2(inputString,"$strikethrough$","<b>");
        //System.out.println(strReplace.replaceTags2(inputString,"$underline$","<u>"));
        
        Map<String,String> tagMap = new HashMap<String,String>();
        tagMap.put("$strikethrough$","<B>");
        tagMap.put("$underline$","<U>");
        System.out.println(strReplace.replaceTags3(inputString,tagMap));
    
        
    
    
    }
    
    
    
}
