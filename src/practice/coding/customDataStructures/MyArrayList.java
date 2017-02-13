package practice.coding.customDataStructures;

import java.util.Arrays;

public class MyArrayList {
    public MyArrayList() {
    }
    
    Object[] myList={};
    static int currSize = 0;
    
    public static void main(String args[]){
        MyArrayList ml = new MyArrayList();
        ml.add(1);
        ml.add(3);
        ml.remove(5);
        System.out.println("ml length="+ml.length());
        for (int i=0; i<ml.length();i++){
            System.out.println("value="+ml.get(i));
        }
    }
    
    public void add( Object o){
        //check for size
        if((myList.length >0) || (myList.length - currSize)<5){
            increaseSize();
        }
        myList[currSize] = o;
        currSize++;
    }
    
    public void remove(int index){
       if(index<myList.length){
           for (int i=index;i<myList.length-1;i++){
              // if(i>=index){
                   myList[i] = myList[i+1];
                   currSize--;
              // }
           }
       }else{
           System.out.println("No such element exists. Array Index Out of bound error for:"+index);
       }
       
    }
    
    public Object get(int index){
        return myList[index];
    }
    
    public int length(){
        return currSize;
    }
    
    
    public void increaseSize(){
        myList = Arrays.copyOf(myList, myList.length*2+1);
    }
}
