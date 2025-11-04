class Solution {
    int minCost(int[] h) {
        // code here
        int n=h.length;
        int dp[]=new int[n+1];
        for(int i=n-2;i>=0;i--){
            int fs=Math.abs(h[i]-h[i+1])+dp[i+1];
            int ss=(int)1e9;
            if(i+2<n) ss=Math.abs(h[i]-h[i+2])+dp[i+2];
            dp[i]=Math.min(fs,ss);
        }
    return dp[0];
    }
}