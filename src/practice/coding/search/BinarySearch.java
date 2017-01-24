package practice.coding.search;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.Date;

//TODO: Not working version
public class BinarySearch {

 
    public BinarySearch() {
    }
    
    public void BSearch(String[] str, String fromTime, String toTime){
        
        int mid = str.length/2;
        int end = str.length - 1;
        Timestamp currMidTime = null;
        Timestamp fromTimeStamp = this.getTimeStamp(fromTime);
        Timestamp toTimeStamp = this.getTimeStamp(toTime);
        
        
        /*check if the time stamp of mid value has a time or no time and if
         * time stamp present verify if it is less or greater than input time stamp range
         * 
         * */
        String midString = str[mid];
        String currMidTimeStr =midString.substring(0,20);
        
        if(currMidTimeStr.contains("-"))
        {
            currMidTime = getTimeStamp(currMidTimeStr);
        }
        

        
        
        /*Binary Search from here*/
        if(mid>=1){
        
            String[] leftStrings = new String[mid];
            
            String[] rightStrings;
            
            if(str.length%2==0){
               rightStrings = new String[mid];
            }else{
                rightStrings = new String[mid+1];
            }
            
            /*traverse left*/
            for(int i=0;i<mid;i++){
                leftStrings[i] = str[i];
            }
            if(currMidTime != null && !currMidTime.after(fromTimeStamp))            
            {
                BSearch(leftStrings,fromTime,toTime);
            }
            
            
            /*traverse right*/
            int k=0;
            for(int j=mid;j<=end;j++){
                rightStrings[k] = str[j];
                k++;
                              
            }
            
            if(currMidTime != null && !currMidTime.before(toTimeStamp))            
            {
            BSearch(rightStrings,fromTime,toTime);
            }
        }else{
            
            System.out.println(str[mid]);
        }
        
        

        
    }
    
    public Timestamp getTimeStamp(String str){
        Timestamp timestp = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            Date parsedDate = dateFormat.parse(str);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            System.out.println("timestamp val="+timestamp.toString());
        }catch(Exception e){
             e.printStackTrace();
         }
         return timestp;
    }
    
}
