class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int ts=0;
        int n=nums.length;
        for(int i:nums) ts+=i;
        if(ts%k!=0) return false;
        int tar=ts/k;
        int[] dp=new int[1<<n];
        Arrays.fill(dp,-1);
    return f(nums,tar,0,0,dp);
    }
    static boolean f(int[] nums,int tar,int mask,int curSum,int[] dp){
        int n=nums.length;
        if(mask==(1<<n)-1) {
            if(curSum==0) return true;
            else return false;
        }
        if(dp[mask]!=-1) return dp[mask]==1;
        for(int i=0;i<n;i++){
            if((mask&(1<<i))!=0) continue;
            if(curSum+nums[i]> tar) continue;
            int newSum=curSum+nums[i];
            int Nmask=(mask | (1<<i));
            if(f(nums,tar,Nmask,newSum%tar,dp)){
                dp[mask]=1;
                return true;
            }
        }
    dp[mask]=0;
    return false;
    }
}


//bitmask dp 

// we keep (0 -> n-1) all set bits 1's for to check is present in subset or not 

// we check 0 to 2 ^n -1 at last we are in all unset bits then we print result;