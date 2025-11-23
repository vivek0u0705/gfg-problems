class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][3];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(0,nums,0,dp);
    }
    public static int f(int i,int[] nums,int s,int[][] dp){
        if(i==nums.length){
           if(s%3==0) return 0;
           return -(int)1e9;
        }
        if(dp[i][s%3]!=-1) return dp[i][s%3]; 
        int nt=0+f(i+1,nums,s,dp);
        int t=nums[i]+f(i+1,nums,s+nums[i],dp);
    return dp[i][s%3]=Math.max(nt,t);
    }
}