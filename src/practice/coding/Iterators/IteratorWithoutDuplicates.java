package practice.coding.Iterators;

/*
Iterator to exclude duplicates
 */

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;

public class IteratorWithoutDuplicates<E> implements Iterator<E> {

    E[] input;
    E[] output;
    int index;

    final Comparator<E> comparator;

    //constructor to initalize input and output
     IteratorWithoutDuplicates(E[] array, Comparator<E> comparator) {
        this.input = array;
        this.comparator = comparator;

        @SuppressWarnings("unchecked")
        final E[] a = (E[]) Array.newInstance(array.getClass(), array.length);
        this.output = a;
    }



    @Override
    public boolean hasNext() {
        return index < input.length;
    }

    @Override
    public E next(){
        if(++index < input.length){
            return input[index];
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }



    //custom method to remove duplicates
    //method to remove array duplicates
    E[] removeDuplicates()
    {

        IteratorWithoutDuplicates<E> myIter = new IteratorWithoutDuplicates<E>(input, comparator );

        E prevElement = null;
        int i = 0;
        while((prevElement = myIter.next()) != null) {
            if(comparator.compare(prevElement, myIter.next()) !=0){
                output[i++] = (E)prevElement;
            }
        }

        return output;

    }


    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17 };
        IteratorWithoutDuplicates<Integer> customIter = new IteratorWithoutDuplicates<Integer>(array, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 != null && o2 != null) {
                    return o1.compareTo(o2);
                }
                return -1;
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });

        IteratorWithoutDuplicates<Integer> outIter = new IteratorWithoutDuplicates<Integer>(customIter.removeDuplicates(), new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 != null && o2 != null) {
                    return o1.compareTo(o2);
                }
                return -1;
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });

        while(outIter.hasNext()){
            System.out.println("printing "+outIter.next());
        }


    }


}

