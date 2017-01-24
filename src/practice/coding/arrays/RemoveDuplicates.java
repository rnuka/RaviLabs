package practice.coding.arrays;


/**
 * Created by rnuka on 10/19/15.
 */
public class RemoveDuplicates {

    //method to remove array duplicates
    int[] removeDuplicates(int[] values)
    {

        //null case
        if(values == null){
            return values;
        }


        // for other non-null cases
        int[] output = new int[values.length];

        //initialize to first element
        int j = 0;

        //compare from second element onwards
        for (int i=0 ; i< values.length-1; i++){
            if(values[i] != values[i+1]){
                output[j++] = values[i];
            }
        }

        //for last element check
        if(values[values.length-2] != values[values.length-1]){
            output[j++] = values[values.length-1];
        }

        //remove unwanted space and update original array
        values = new int[j];
        System.arraycopy( output, 0, values, 0, j ) ;


        return values;

    }

    //test
    public static void main(String[] args){

        int[] input = { 1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17 };

        System.out.println("before removal");

        for(int curr: input){
            System.out.print(" "+curr);
        }

        RemoveDuplicates rd = new RemoveDuplicates();

        System.out.println("length="+rd.removeDuplicates(input).length);

        input = rd.removeDuplicates(input);

        System.out.println("");
        System.out.println("after removal");

        for(int curr: input){
            System.out.print(" "+curr);
        }
    }
}
