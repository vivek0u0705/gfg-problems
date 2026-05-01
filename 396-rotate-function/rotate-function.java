class Solution {
    public int maxRotateFunction(int[] nums) {
        int ts=0;
        int n=nums.length;
        for(int i:nums) ts+=i;
        int s=0;
        for(int i=0;i<n;i++){
            s+=i*nums[i];
        }
        int max=s;
        int ps=s;
        for(int i=1;i<n;i++){
            int cur=ps+ts-(n-1)*nums[n-i] - nums[n-i];
            ps=cur;
            max=Math.max(max,cur);
        }
    return max;
    }
}