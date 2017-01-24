package practice.coding;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TestClass {

    public static int[] array = new int[10000] ;
    //public static int[] array = {1,2,3,4,20,101,100,11,7,6} ;
    // public static int[] array = new int[4] ;


    public static void testString(String input){
        System.out.println("modified input inside method::"+input.replaceAll("[^A-Za-z0-9]",""));
    }

    public TestClass() {
    }
    public static void main(String args[]){


        String s = "abc";
        System.out.println("substring::"+s.substring(s.length(),s.length()));


        String s1 = "s1 literal";
        String s2 = "s1 literal";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println("s1==s2? ::"+(s1==s2));
        System.out.println("s3==s4? ::"+(s3==s4));






        String input="##123,.^%$";
        System.out.println("original:" + input);
        testString(input);
        System.out.println("after function call::"+input);


        int i = 8;

        int len = 0;

        while (i != 0) {
            len += (i & 1);
            i >>>= 1;
        }

        System.out.println("len="+len);




        System.out.println("i after 16 shifts left "+(i));
        
        /*Test: Number Reverse*/
        /*
        NumberReverse rev = new NumberReverse();
        int n = rev.reverse(1111112);
        System.out.println("Reverse number="+n);
        */
        
        
        
        /*Test: String Reverse*/
        /*
        StringReverse revStr = new StringReverse();
        String str = revStr.reverse("sravanthi");
        System.out.println("reverse String="+str);
        */
        
        
        
        /*Test: Binary Serach*/
        
         /*String str[]={"21-dec-2014 01:01:01 Null  pointer exception",
                       "                    at line 1",
                       "                    at line 2",
                       "21-dec-2014 02:01:01 time is two o clock",
                       "21-dec-2014 03:01:01 time is three o clock",
                       "21-dec-2014 04:01:01 time is four o clock",
                       "21-dec-2014 04:31:01 time is four o clock",
                       "21-dec-2014 04:51:01 time is four o clock",
                       "21-dec-2014 05:01:01 time is five o clock",
                       "                     at line 51",
                       "                     at line 52",
                       "21-dec-2014 05:15:01 time is five o clock",
                       "21-dec-2014 06:01:01 time is six o clock",
                       "21-dec-2014 07:01:01 time is seven o clock",
                       "21-dec-2014 08:01:01 time is eight o clock",
                       "21-dec-2014 09:01:01 time is nine o clock",
                       "21-dec-2014 10:01:01 time is ten o clock",
                       "                    at line 101",
                       "                    at line 102"
         
                       };
        
        BinarySearch bsearch = new BinarySearch();
        bsearch.BSearch(str,"21-dec-2014 02:31:01","21-dec-2014 04:31:01");
        */
        
        
        /*Test: Merge Sort*/
        /*int[] array = {5,4,3,2,1,4,2};
        System.out.println("lenght="+(array.length));
        int[] mArray = new int[array.length];
        MergeSort m = new MergeSort(array.length);
        mArray = m.mergeSort(array,0,array.length-1);
        System.out.println("sorted first element"+mArray[0]);
        System.out.println("sorted first element"+mArray[1]);
        System.out.println("sorted first element"+mArray[2]);
        System.out.println("sorted first element"+mArray[3]);
        System.out.println("sorted first element"+mArray[4]);
        System.out.println("sorted first element"+mArray[5]);
        System.out.println("sorted first element"+mArray[6]);
        */
        
        
        
        
        /*Test: Inversion Count*/
        
       /*  long invCount = 0;
         
         
        
        //read the file from external file and store lines as array elements
         File testFile = new File("/Users/rnuka/Desktop/IntegerArray.txt");
        //File testFile = new File("/Users/rnuka/Desktop/smaller.txt");
        System.out.println(getContents(testFile));
         //System.out.println("last element="+array[100000-1]);
        
        
             System.out.println("Counting inversions now...");
        
                int[] mArray = new int[array.length];
                InversionCount m = new InversionCount(array.length);
                invCount = m.mergeSort(array,0,array.length-1);
                //mArray = m.mergeSort(array,0,array.length-1);
                 
                System.out.println("invCount="+invCount);
                
               
        */
                
       /*Test: quick sort*/
       /* //int[] array = {11,4,14,23};
        int[] array = {11,4,14,23,2001,99,59,65,23,11,43,49,73,81,99,2,3,4,5};
        //int[] array = {11,4,14,99,65};
        System.out.println("array before sorting:");
        for(int p=0;p<array.length;p++){
            System.out.print(array[p]+"  ");
        }
        System.out.println("\n lenght="+(array.length));
        QuickSort q = new QuickSort();
        q.qSort(array,0,array.length-1);
        
        //print sorted array
        System.out.println("Final sorted array:");
        for(int p=0;p<array.length;p++){
            System.out.print(array[p]+"  ");
        }
        
        */
        
        
        
        /*Test: quick sort high*/
         //int[] array = {11,4,14,23};
        /*int[] array = {11,4,14,23,2001,99,59,12,13,16,17,19,101,65,23,11,43,49,73,81,99,2,3,4,5};
        //int[] array = {14,99,65,99};
        System.out.println("array before sorting:");
        for(int p=0;p<array.length;p++){
        System.out.print(array[p]+"  ");
        }
        System.out.println("\n lenght="+(array.length));
        QuickSortCounting q = new QuickSortCounting();
        long cnt = q.qSort(array,0,array.length-1);
        
        //print sorted array
        System.out.println("Final sorted array:");
        for(int p=0;p<array.length;p++){
        System.out.print(array[p]+"  ");
        }*/
        
        
         /*Test: quick sort middle*/
         /* //int[] array = {11,4,14,23};
         //int[] array = {11,4,14,23,2001,99,59,65,23,11,43,49,73,81,99,2,3,4,5};
         int[] array = {14,99,6,14,11,21};
         System.out.println("array before sorting:");
         for(int p=0;p<array.length;p++){
         System.out.print(array[p]+"  ");
         }
         System.out.println("\n lenght="+(array.length));
         QuickSortMiddle q = new QuickSortMiddle();
         q.qSort(array,0,array.length-1);
         
         //print sorted array
         System.out.println("Final sorted array:");
         for(int p=0;p<array.length;p++){
         System.out.print(array[p]+"  ");
         }
         */
         
        
        
        
        
        
        /*Test: quick sort count*/
        /*  long qsortCompCount = 0;
          
         //read the file from external file and store lines as array elements
         File testFile = new File("/Users/rnuka/Desktop/QuickSort.txt");
         System.out.println(getContents(testFile));
         System.out.println("last element="+array[10000-1]);
         
         System.out.println("Counting quick sort comparisons now...");
         
         QuickSortCounting q = new QuickSortCounting();
         qsortCompCount = q.qSort(array,0,array.length-1);
                  
         System.out.println("qsortCompCount="+qsortCompCount);
         */
         

         /*Test: RandomDice*/
         //RandomDice d= new RandomDice();
         //d.randomNumber(1,6);
         
         

         
    }
    
    static public String getContents(File aFile) {
        //...checks on aFile are elided
        StringBuilder contents = new StringBuilder();
        int i = 0;
        
        try {
          //use buffering, reading one line at a time
          //FileReader always assumes default encoding is OK!
          BufferedReader input =  new BufferedReader(new FileReader(aFile));
          try {
            String line = null; //not declared within while loop
            /*
            * readLine is a bit quirky :
            * it returns the content of a line MINUS the newline.
            * it returns null only for the END of the stream.
            * it returns an empty String if two newlines appear in a row.
            */
            while (( line = input.readLine()) != null){
              array[i] = new Integer(line);
              contents.append(line);
              contents.append(System.getProperty("line.separator"));
              i++;
            }
          }
          finally {
            input.close();
          }
        }
        catch (IOException ex){
          ex.printStackTrace();
        }
        
        return contents.toString();
      }
}
