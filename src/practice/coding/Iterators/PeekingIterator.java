package practice.coding.Iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/*
 Given an Iterator class interface with methods: next() and hasNext(),
 design and implement a PeekingIterator that support the peek() operation

-- it essentially peek() at the element that will be returned by the next call to next().


Example: Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
--------

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.


Follow up: How would you extend your design to be generic and work with all types, not just integer?
  */
public class PeekingIterator<E> implements Iterator<E> {

    E next;
    Iterator<E> iterator;

    public PeekingIterator(Iterator iterator){
        this.iterator = iterator;
        next = this.iterator.hasNext() ?  this.iterator.next(): null;  //initialize next
    }

    @Override
    public boolean hasNext() {
        return !(next == null);
    }

    @Override
    public E next(){
        E result = next;
        next = iterator.hasNext() ?  iterator.next(): null;  //get next and keep it ready
        return result;
    }

    public E peek(){
        return next;
    }

    static void testStringList(List<String> input){
        System.out.println("inside testset1");
        PeekingIterator p = new PeekingIterator(input.iterator());
        while(p.hasNext()){
            System.out.println("peek = "+p.peek());
            System.out.println("next = "+p.next());
            System.out.println("next peek = "+p.peek());
        }
    }



    static void testIntegerList(List<Integer> input){
        System.out.println("inside testset1");
        PeekingIterator p = new PeekingIterator(input.iterator());
        while(p.hasNext()){
            System.out.println("peek = "+p.peek());
            System.out.println("next = "+p.next());
            System.out.println("next peek = "+p.peek());
        }
    }

    static void testbed() {
        System.out.println("******* Integer List testing *******");
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        testIntegerList(myList);

        System.out.println("******* String List testing *******");
        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("xyz");
        stringList.add("pqr");
        testStringList(stringList);
    }

    public static void main(String args[]){
        testbed();
    }
}
