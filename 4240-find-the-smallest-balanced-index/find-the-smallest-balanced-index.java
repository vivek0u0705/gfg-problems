class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        long arr1[]=new long[n];
        long arr2[]=new long[n];
        arr1[0]=0;
        arr2[n-1]=1;
        long lt=(long)1e18;
        for(int i=1;i<n;i++){
            arr1[i]=arr1[i-1]+(long)nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            if(arr2[i+1]> lt/(long)nums[i+1]){
                arr2[i]=-1;
            }
            else arr2[i]=arr2[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            if(arr1[i]==arr2[i]){
                return i;
            }
        }
    return -1;
    }
}