class Solution {
    Integer[][] dp;
    public int minOperations(int[] nums, int sum) {
        int n=nums.length;
        dp=new Integer[n][sum+1];
        int ans= f(0,nums,sum);
    return ans==(int)1e9?-1:ans;
    }
    int f(int i,int[] nums,int sum){
        if(sum<0) return (int)1e9;
        if(sum==0) return 0;
        if(i==nums.length){
            return (int)1e9;
        }

        if(dp[i][sum]!=null) return dp[i][sum];

        int nt=f(i+1,nums,sum); // not take 
        int takeF=f(i+1,nums,sum-nums[i]); //take num without oprtaions
        int ans=Math.min(takeF,nt); // keepMin by checking fullyTake and skip
        int x=nums[i]*2;
        int ct=1;
        //always do mul first 
        while(x<=sum){
            int t=ct+f(i+1,nums,sum-x);
            ans=Math.min(ans,t); // check for all possible counts
            x=x*2;
            ct++;
        }
        x=nums[i]/2;
        ct=1;
        //div
        while(x>=1){
            int t=ct+f(i+1,nums,sum-x);
            ans=Math.min(ans,t); // check for all possible counts
            x=x/2;
            ct++;
        }
        
    return dp[i][sum]=ans;
    }
}