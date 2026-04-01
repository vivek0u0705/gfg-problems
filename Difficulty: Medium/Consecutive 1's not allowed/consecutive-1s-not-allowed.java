class Solution {
    int countStrings(int n) {
        // code here
        // int len=(int)Math.pow(2,n);
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
    return f(0,n,0,dp);
    }
    public static int f(int i,int n,int pre,int[][] dp){
        if(i==n) return 1;
        if(dp[i][pre]!=-1) return dp[i][pre];
        int c1=f(i+1,n,0,dp);
        int c2=0;
        if(pre==0){
            c2=f(i+1,n,1,dp);
        }
    return dp[i][pre]=c1+c2;
    }
}
