package practice.coding.cache;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;
import java.util.HashSet;

public class Cache{
    
    Map<Integer,Tweet> cache = new ConcurrentHashMap<Integer,Tweet>();
    String FILE_PATH = "/Users/rnuka/Documents/Useful_Study/tweet_db/TweetyPie.txt";  //can be read from config file
    Long MAX_TIME_LIMIT=new Long(20);
    Integer MAX_CACHE_SIZE=3;
    
    public Cache() {
    }
    
    
    

    
    //Cache service reads from File
    private String readTweet(int tweetId){
        System.out.println("fetching from file..");
        String tweetIdStr = new Integer(tweetId).toString();
        try{BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            int counter=0;
            boolean tweetFound=false;
            while((line = fileReader.readLine()) !=null){
                for(String token:line.split(",")){
                    counter++;
                    if(tweetFound){
                        return token.substring(2,token.length()-1);
                    }
                    if(counter==1 && token.equalsIgnoreCase(tweetIdStr)){
                        tweetFound=true;
                    }
                }
                counter=0; //reset counter
                tweetFound=false; //reset flag
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return "";
    }
    
    
    //Cache service writes to File
    private void writeTweet(int tweetId, String tweet){
        
    }
    
    
    
    //Client call to get Tweet
    public String getTweet(int tweetId){
    
        //Check if the tweet is available in Cache
        if(!cache.isEmpty() && cache.get(tweetId) != null){
            cache.get(tweetId).setReadCount(cache.get(tweetId).getReadCount()+1);  //increase read count
            System.out.println("fetching from cache..");
            return cache.get(tweetId).getTweetText();
        }else{  
                //update cache and return the value if not available
                String tweet = readTweet(tweetId);
                if(cache.size() < MAX_CACHE_SIZE){
                    Long nanoTime = System.nanoTime();
                    Tweet tweetObj = new Tweet(nanoTime);
                    tweetObj.setReadCount(1);
                    tweetObj.setTweetText(tweet);
                    cache.put(tweetId,tweetObj);
                }else{
                    System.out.println("cache is full..");
                }
            return tweet;
        }
        
    }
    
    //Client put method call
    public void putTweet(int tweetId,String tweet){
        //if cache is free then store it in cache otherwise skip cache storage
        if(!cache.isEmpty() && cache.size()<MAX_CACHE_SIZE){
            Long nanoTime = System.nanoTime();
            Tweet tweetObj = new Tweet(nanoTime);
            tweetObj.setReadCount(1);
            tweetObj.setTweetText(tweet);
            cache.put(tweetId,tweetObj);
        }
            
        //store in file
        //TODO
    }
    
    //handle timeouts
   // private final Runnable evictor = new Runnable() {
        public void run(){
            Set<Integer> expiredTweets = new HashSet<Integer>();
            long currentTime = System.nanoTime();
            for(Map.Entry tweet : cache.entrySet()){
                Tweet currTweet = (Tweet)tweet.getValue();
                long interval =  currentTime - currTweet.getTweetTimeStamp();
                double elapsedTime = (double)interval / 1000000000.0;
                if(elapsedTime > 10){
                    cache.remove(tweet.getKey());
                }
                
            }
        }
        
        
    //testing
    public static void main(String args[]){
        Cache cacheService = new Cache();
        System.out.println("start");
        System.out.println(cacheService.getTweet(13));
        System.out.println(cacheService.getTweet(14));
        System.out.println(cacheService.getTweet(15));
        System.out.println(cacheService.getTweet(16));
        System.out.println(cacheService.getTweet(13));
        System.out.println(cacheService.getTweet(14));
        System.out.println(cacheService.getTweet(15));
        System.out.println(cacheService.getTweet(19));
        System.out.println(cacheService.getTweet(13));
        System.out.println(cacheService.getTweet(14));
        System.out.println(cacheService.getTweet(15));
        
    }
     }
    
    //handle refresh
    
    
    //handle eviction based on reTweets
    
    
    //cache stats
    

    
   

