class Solution {
    public int tsp(int[][] cost) {
        // code here
        int n=cost.length;
        int mask=1;
        int dp[][]=new int[n][1<<n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(0,cost,mask,n,dp); //0 is already visited?
        
    }
    static int f(int i,int[][] cost,int mask,int n,int dp[][]){
        if(Integer.bitCount(mask)==n) return cost[i][0];
        if(dp[i][mask]!=-1) return dp[i][mask];
        int ans=(int)1e9;
        for(int j=0;j<n;j++){
            if(i!=j && (mask & (1<<j))==0){
                ans=Math.min(ans,cost[i][j]+f(j,cost, mask | (1<<j),n,dp));
            }
        }
    return dp[i][mask]=ans;
    }
}



//b