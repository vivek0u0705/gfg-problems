class Solution {
    static int noOfWays(int m, int n, int x) {
        // code here
        int dp[][]=new int[n+1][x+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
    return f(1,m,n,x,0,dp);
    }
    public static int f(int i,int m,int n,int x,int s,int dp[][]){
        if(s>x) return 0;
        if(i>n){
            if(s==x) return 1;
            else return 0;
        }
        if(dp[i][s]!=-1) return dp[i][s];
        int ct=0;
        for(int idx=1;idx<=m;idx++){
            ct+=f(i+1,m,n,x,s+idx,dp);
        }
    return dp[i][s]=ct;
    }
};