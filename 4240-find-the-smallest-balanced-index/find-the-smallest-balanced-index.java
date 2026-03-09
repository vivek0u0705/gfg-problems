class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        long arr1[]=new long[n];
        long arr2[]=new long[n];
        arr1[0]=0;
        arr2[n-1]=1;
        long lt=(long)1e18;
        for(int i=1;i<n;i++){
            arr1[i]=arr1[i-1]+nums[i-1];
        }
        int idx=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1] > lt/arr2[i+1]){
                idx=i;
                arr2[i]=-1;
                break;
            }
            else arr2[i]=arr2[i+1]*nums[i+1];
        }
        for(int i=idx;i<n;i++){
            if(arr1[i]==arr2[i]){
                return i;
            }
        }
    return -1;
    }
}