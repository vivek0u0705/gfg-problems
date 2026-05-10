class Solution {
    public int maximumJumps(int[] nums, int tar) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans=f(nums,0,tar,dp);
    return ans<0?-1:ans;
    }
    public static int f(int[] nums,int i,int tar,int dp[]){
        int n=nums.length;
        if(i==n-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int maxS=-(int)1e9;
        for(int j=i+1;j<n;j++){
            int val=nums[j]-nums[i];
            if(-tar<=val && val<=tar){
                int next=f(nums,j,tar,dp);
                if(next!=-(int)1e9) maxS=Math.max(maxS,1+next); // - 1e9 means no valid state from o  -> n-1
            }
        }
    return dp[i]=maxS;
    }
}