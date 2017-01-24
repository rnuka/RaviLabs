package practice.coding.histograms;

/**
 * Created by rnuka on 12/31/16.
 */
public class TrapRainWater1 {

    int trap(int A[], int n) {
        int left=0; int right=n-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(A[left]<=A[right]){
                if(A[left]>=maxleft) maxleft=A[left];
                else res+=maxleft-A[left];
                left++;
            }
            else{
                if(A[right]>=maxright) maxright= A[right];
                else res+=maxright-A[right];
                right--;
            }
        }
        return res;
    }


    int findWater(int arr[], int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int[] left = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int[] right = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = 0;
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i-1]);

        // Fill right array
        right[n-1] = 0;
        for (int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i+1]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.max(0,Math.min(left[i], right[i]) - arr[i]);

        return water;
    }

    public void testcase1(){
        int[] heights = {5,1,3,4};
        System.out.println("Maximum water that can be trapped using trap method = "+trap(heights,heights.length));
        System.out.println("Maximum water that can be trapped using findWater method = "+findWater(heights, heights.length));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        TrapRainWater1 t =  new TrapRainWater1();
        t.testbed();
    }
}
