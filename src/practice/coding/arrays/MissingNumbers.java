package practice.coding.arrays;

/**
 * Created by rnuka on 6/7/16.
 */
import java.util.*;

public class MissingNumbers {

    public static void printMissing(int[] first, int[] second ){
        Arrays.sort(first);
        Arrays.sort(second);

        int firstSize = first.length;
        int secondSize = second.length;

        Integer[] missing = new Integer[secondSize - firstSize];

        int j=0;
        int k=0;
        for(int i=0; i<secondSize; i++){
            if(second[i] != first[i]){
                missing[k]=second[i];
                k++;
            }else{
                j++;
            }
        }
        Set<Integer> uniqueSet = new HashSet<Integer>(Arrays.asList(missing));
        uniqueSet.toArray();
        Object[] objArray= uniqueSet.toArray();
        missing = Arrays.copyOf(objArray, objArray.length, Integer[].class);
        Arrays.sort(missing);
        for(int i=0; i<missing.length; i++){
            System.out.print(missing[i]+" ");
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int firstListSize = sc.nextInt();
        int[] firstList = new int[firstListSize];
        for(int i=0; i<firstListSize; i++){
            firstList[i] = sc.nextInt();
        }

        int secondListSize = sc.nextInt();
        int[] secondList = new int[secondListSize];
        for(int i=0; i<secondListSize; i++){
            secondList[i] = sc.nextInt();
        }

        printMissing(firstList, secondList);


    }
}
