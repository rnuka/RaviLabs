package practice.coding.arrays;
/*
http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. The array might also contain duplicates. You may assume that both x and y are different and present in arr[].

Examples:
Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.

 */
public class MinimumDistanceBetweenTwoNumbers {

    int minDist(int arr[], int n, int x, int y)
    {
        int i = 0;
        int min_dist = Integer.MAX_VALUE;
        int prev=0;

        // Find the first occurence of any of the two numbers (x or y)
        // and store the index of this occurence in prev
        for (i = 0; i < n; i++)
        {
            if (arr[i] == x || arr[i] == y)
            {
                prev = i;
                break;
            }
        }

        // Traverse after the first occurence
        for (; i < n; i++)
        {
            if (arr[i] == x || arr[i] == y)
            {
                // If the current element matches with any of the two then
                // check if current element and prev element are different
                // Also check if this value is smaller than minimum distance
                // so far
                if (arr[prev] != arr[i] && (i - prev) < min_dist)
                {
                    min_dist = i - prev;
                    prev = i;
                }
                else
                    prev = i;
            }
        }

        return min_dist;
    }
}
