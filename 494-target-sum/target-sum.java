class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ts=0;
        for(int i:nums) ts+=i;
        if(ts<target) return 0;
        if((ts-target)%2!=0) return 0;
        int tar=(ts-target)/2;
        return f(nums.length-1,nums,tar);
    }
    public int f(int i,int[] nums,int tar){
        if(i==0){
            if(tar==0 && nums[0]==0) return 2;
            if(tar==0 || tar==nums[0]) return 1;
            else return 0;
        }

        int nt=f(i-1,nums,tar);
        int t=0;
        if(tar>=nums[i]) t=f(i-1,nums,tar-nums[i]);
        return t+nt;
    }
}