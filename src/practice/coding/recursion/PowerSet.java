package practice.coding.recursion;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class PowerSet<T> {
    public PowerSet() {
    }
    
    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }      
        return sets;
    }
    
    public static <T> void main(String args[]){
         Set<String> mySet = new HashSet<String>();
         mySet.add("a");
         mySet.add("b");
         mySet.add("c");
         mySet.add("d");

         for (Set<String> s : PowerSet.powerSet(mySet)) {
             System.out.println(s);
         }
    }
}
