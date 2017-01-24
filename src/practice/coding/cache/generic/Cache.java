package practice.coding.cache.generic;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rnuka on 9/28/15.
 */
public class Cache {

    final int CACHE_SIZE=3;
    public Map<Object,Object> cache= new LinkedHashMap<Object,Object>();




    public Object getHead(){
        return cache.entrySet().iterator().next().getKey();
    }

    //always remove the head
    private void evict(){
        cache.remove(getHead());
    }

    //if Object exists, remove from current position and put at the end
    //else if space is not available evict and put at the end
    public void lookUp(Object o){

        if(cache.containsKey(o))
            cache.remove(o);

        if(cache.size()==CACHE_SIZE)
            evict();

        cache.put(o,o);
    }

    public void printCache(){
        System.out.println("-----");
        for(Map.Entry<Object,Object> currObject: cache.entrySet()){
            System.out.println("object of"+currObject.toString());
        }
    }

    public static void main(String args[]){
        Cache cache = new Cache();
        Object o1=new Integer(1);
        Object o2=new BigDecimal(19);
        Object o3=new Object();
        cache.lookUp(o1);
        cache.printCache();
        cache.lookUp(o2);
        cache.printCache();
        cache.lookUp(o3);
        cache.printCache();
        cache.lookUp(o2);
        cache.printCache();
        Object o4=new Object();
        cache.lookUp(o4);
        cache.printCache();
    }




}
