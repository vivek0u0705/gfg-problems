class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int ts=0;
        int max=nums[0];
        for(int i=0;i<n;i++){
            ts+=nums[i];
            max=Math.max(nums[i],max);
        }
        int low=max;
        int high=ts;
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int t=f(mid,nums);
            if(t<=k){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
    return res;
    }
    public static int f(int val,int[] nums){
        int n=nums.length;
        int ct=1;
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+nums[i]<=val){
                sum+=nums[i];
            }
            else{
                ct++;
                sum=nums[i];
            }
        }
    return ct;
    }
}