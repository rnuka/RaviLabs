package practice.coding.sort;


/*

http://www.geeksforgeeks.org/nearly-sorted-algorithm/

Let the partially sorted array be array [0, 1, n - 1] . The algorithm to sort this array will be :

Solution Steps:
----------------

step-1: Create a sliding window of size 2k .

step-2:  Start by keeping the window between the index 0 and 2k . Sort the input array inside the window interval.
Now the elements between 0 and k-1 are in their final sorted position since the elements in the array can be
misplaced by no more than k positions.

step-3:  Slide the window forward by k . Now the window is between k and 3k . Sort the elements in the array inside the
window interval and elements between k and 2k - 1 are now sorted.
step-4: Continue this by sliding the window forward by k at each iteration and sort the array within the window interval
until we sort array [ik, ik + 1, ... , n] .


Time Complexity:
----------------
At each iteration we are sorting 2k elements. Therefore, time to sort at each iteration is O(klogk)O(klogk) . There will be
total (nk)(nk) numbers of iterations.

Therefore, total time complexity = O(nlogk)


* */
public class SortPartiallySortedArray {
    void sort(int[] input, int k){
        for(int i=0; i<input.length; i=i+k){
            //create a sliding window of 2k
            for(int j=i; j<(i+2*k); j++){

            }
        }
    }
}
