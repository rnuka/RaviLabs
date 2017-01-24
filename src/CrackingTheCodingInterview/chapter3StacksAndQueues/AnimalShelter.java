package CrackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.LinkedList;

/**
 * Created by rnuka on 10/16/15.
 */
/*
Question 3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals
at the shelter, or they can select whether they would prefer a dog or a cat (and will
receive the oldest animal of that type). They cannot select which specific animal they
would like. Create the data structures to maintain this system and implement operations
such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may
use the built-in LinkedL ist data structure
 */
public class AnimalShelter {

    LinkedList<Animal> sheltor = new LinkedList<Animal>();

    public class Animal{
        String animalType;
        String animalEntryTime;
    }

    //enqueue
    public void enqueue(Animal a){
        sheltor.push(a);
    }

    //dequeueAny

    //dequeueDog

    //dequeueCat
}
