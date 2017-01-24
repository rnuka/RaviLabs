package practice.coding.search;

/*

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
your product fails the quality check. Since each version is developed based on the previous version, all the versions
after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find
the first bad version. You should minimize the number of calls to the API.

Assumption: Input List of version is sorted, otherwise we need to sort before binary search solution.

* */
public class FirstBadVersion {

    //Approach: Use Simple Binary Search on array of Version object

    public static class Version {
        String version;
        boolean isVersionBad;

        public Version(String version, boolean isVersionBad) {
            this.version = version;
            this.isVersionBad = isVersionBad;
        }
    }



    public int firstBadVersion(Version[] versionArray){

        return firstBadVersion(versionArray, 0, versionArray.length-1);
    }



    private int firstBadVersion(Version[] versionArray, int low, int high){

        if(low>=high && !versionArray[low].isVersionBad){
            return -1;
        }

        int mid = (low+high)/2;

        //return mid if previous version is good of mid is in 0 index
        if(versionArray[mid].isVersionBad && (mid == 0 || !versionArray[mid-1].isVersionBad)){
            return mid;
        }else {

            if(versionArray[mid].isVersionBad) {

                return firstBadVersion(versionArray, low, mid);

            }else{
                return  firstBadVersion(versionArray, mid + 1, high);
            }

        }
    }
}
