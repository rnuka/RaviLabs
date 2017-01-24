package practice.coding.cache;

public class Tweet {
    public Tweet(Long timeOut) {
        TIME_STAMP = timeOut;
    }
    
    final Long TIME_STAMP;
    private String tweetText;
    private Integer readCount;
    
    
    public void setReadCount(Integer value){
        readCount = value;
    }
    
    public Integer getReadCount(){
        return readCount;
    }
    
    
    public void setTweetText(String value){
        tweetText = value;
    }
    
    public String getTweetText(){
        return tweetText;
    }
    
    public Long getTweetTimeStamp(){
        return TIME_STAMP;
    }
    
    
    
    
}
