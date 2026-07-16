class Solution {
    Integer[][] dp;
    public int countWays(int n, int sum) {
        // code here
        dp=new Integer[n][sum+1];
        int val=f(0,n,sum);
        return val==0?-1:val;
    }
    public int f(int i,int n,int tar){
        if(i==n) return tar==0?1:0;
        if(tar<0) return 0;
        
        if(dp[i][tar]!=null) return dp[i][tar];
        
        int ans=0;
        for(int j=0;j<=9;j++){
        if(i==0 && j==0) continue;
            ans+=f(i+1,n,tar-j);
        }
    return dp[i][tar]=ans;
    }
};