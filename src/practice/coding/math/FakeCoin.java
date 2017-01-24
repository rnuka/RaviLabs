package practice.coding.math;

/**
 * Created by rnuka on 4/22/16.
 */
/*
* input: Given n coins with all same weight except one different and a common balance is given
* output: print how many weighs are needed to identify the false coin
* */
public class FakeCoin {

     static int numberOfWeighs=0;
     static int size;

    public static int weight ( int[] coinsArr, int fromIndex, int toIndex){
        int sum=0;
        for( int i=fromIndex; i <=toIndex; i++){
            sum += coinsArr[i];
        }
        return sum;
    }

    public static int findFake(int[] coins, int low, int high){

        int retval = -1;
        int extra = -1;
        int mid = (low + high)/2;

        //check if the number of coins is odd
        if((high-low)%2 == 0){
            extra = mid;
            mid = mid-1;
        }

        //do common balance
        int left_weight = weight(coins, low, mid);
        int right_weight = weight(coins,mid+1,high);

        ++numberOfWeighs;
        System.out.println("weigh for low="+low+" and mid="+mid+" and high="+high+" with extra="+extra);

        //if left weight and right weight are equal
        if(left_weight == right_weight){
            if(extra != -1){

                //very first weigh with extra as fake, no need to do any other weigh
                if(high==size){
                    return extra;
                }
                //otherwise check if extra coin is fake
                ++numberOfWeighs;
                if(coins[extra] != coins[low]){
                    return extra;
                }
            }
            return -1;
        }

        //If there is only one coin on each side
        if( mid == low){
            ++numberOfWeighs;
            //check if low is good
            if(coins[low] == coins[2] && coins[low] == coins[0]){
                return high;
            }
            return low;
        }

        //else recurse
        return ((retval = findFake(coins, low, mid)) ==-1 ? findFake(coins, mid+1, high): retval);

    }

    public static void main(String args[]){
        int[] coins = new int[90];
        coins[49] = 3;
        int fromIndex =0, toIndex=coins.length-1;
        size = toIndex;
        System.out.println("fake coin position =" + findFake(coins, fromIndex, toIndex));
        System.out.println("number of weighs="+numberOfWeighs);
    }
}
