class Solution {
    public int minRemovals(int[] nums, int t) {
        int tot=0;
        for(int i:nums) tot^=i;
        int req=tot^t;
        int n=nums.length;
        int nn=(int)(Math.log(10000)/Math.log(2))+1;
        int MAX=(int)Math.pow(2,nn);
        int dp[][]=new int[n][MAX];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int rem=f(0,req,nums,dp);
    if(rem==(int)1e9) return -1;
    return rem;
    }
    public static int f(int i,int req,int nums[],int dp[][]){
        if(i==nums.length){
            if(req==0) return 0;
            else return (int)1e9;
        }
        if(dp[i][req]!=-1) return dp[i][req];
        int t=1+f(i+1,req^nums[i],nums,dp);
        int nt=0+f(i+1,req,nums,dp);
    return dp[i][req]=Math.min(t,nt);
    }
}